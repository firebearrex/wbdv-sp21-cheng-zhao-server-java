package com.example.wbdvsp2102chengserverjava.services;

import com.example.wbdvsp2102chengserverjava.models.Widget;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WidgetService {
    private List<Widget> widgets = new ArrayList<Widget>();
    {
        Widget w1 = new Widget(123l, "ABC123", "HEADING", 1, "111@Welcome to WebDev!");
        Widget w2 = new Widget(234l, "ABC123", "PARAGRAPH", 1, "222@Welcome to WebDev!");
        Widget w3 = new Widget(345l, "ABC234", "HEADING", 2, "333@Welcome to WebDev!");
        Widget w4 = new Widget(456l, "ABC234", "PARAGRAPH", 1, "444@Welcome to WebDev!");
        Widget w5 = new Widget(456l, "ABC234", "PARAGRAPH", 1, "555@Welcome to WebDev!");

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
}
