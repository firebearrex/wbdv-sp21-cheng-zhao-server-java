package com.example.wbdvsp2102chengserverjava.services;

import com.example.wbdvsp2102chengserverjava.models.Widget;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class WidgetService {
    private List<Widget> widgets = new ArrayList<Widget>();
    {
        Widget w1 = new Widget(123, "ABC123", "HEADING", 1, "111@Welcome to WebDev!");
        Widget w2 = new Widget(234, "ABC123", "PARAGRAPH", 1, "222@Welcome to WebDev!");
        Widget w3 = new Widget(345, "ABC234", "HEADING", 2, "333@Welcome to WebDev!");
        Widget w4 = new Widget(456, "ABC234", "PARAGRAPH", 1, "444@Welcome to WebDev!");
        Widget w5 = new Widget(456, "ABC234", "PARAGRAPH", 1, "555@Welcome to WebDev!");

        widgets.add(w1);
        widgets.add(w2);
        widgets.add(w3);
        widgets.add(w4);
        widgets.add(w5);
    }

    public List<Widget> findAllWidgets() {
        return widgets;
    }

    public List<Widget> findWidgetsForTopic(String tid) {
        List<Widget> ws = new ArrayList<Widget>();
        for (Widget widget : this.widgets) {
            if (widget.getTopicId().equals(tid)) {
                ws.add(widget);
            }
        }
        return ws;
    }

    public Widget createWidget(String tid, Widget widget) {
        widget.setTopicId(tid);
        try {
            widget.setId(Math.toIntExact(new Date().getTime()));
        } catch (ArithmeticException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
//        widget.setType("Heading");
//        widget.setSize(1);
        widgets.add(widget);

        return widget;
    }

    public int updateWidget(String wid, Widget widget) {
        int status = 0;

        for (int i = 0; i < widgets.size(); ++i) {
            int widgetId = -1;

            try {
                widgetId = Integer.parseInt(wid);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
            }

            if (widgets.get(i).getId() == widgetId) {
                widgets.set(i, widget);
                status = 1;
            }
        }

        return status;
    }

    public int deleteWidget(String wid) {
        int status = 0;

        for (int i = 0; i < widgets.size(); ++i) {
            int widgetId = -1;

            try {
                widgetId = Integer.parseInt(wid);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
            }

            if (widgets.get(i).getId() == widgetId) {
                widgets.remove(i);
                status = 1;
            }
        }

        return status;
    }

    public Widget findWidgetById(String wid) {
        for (Widget widget : widgets) {
            int widgetId = -1;

            try {
                widgetId = Integer.parseInt(wid);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
            }

            if (widget.getId() == widgetId) {
                return widget;
            }
        }

        return new Widget();
    }
}
