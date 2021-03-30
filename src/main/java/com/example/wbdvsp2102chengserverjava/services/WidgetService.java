package com.example.wbdvsp2102chengserverjava.services;

import com.example.wbdvsp2102chengserverjava.models.Widget;
import com.example.wbdvsp2102chengserverjava.repositories.WidgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class WidgetService {
    private List<Widget> widgets = new ArrayList<Widget>();
//    {
//        Widget w1 = new Widget(123l, "ABC123", "HEADING", 1, "111@Welcome to WebDev!");
//        Widget w2 = new Widget(234l, "ABC123", "PARAGRAPH", 1, "222@Welcome to WebDev!");
//        Widget w3 = new Widget(345l, "ABC234", "HEADING", 2, "333@Welcome to WebDev!");
//        Widget w4 = new Widget(456l, "ABC234", "PARAGRAPH", 1, "444@Welcome to WebDev!");
//        Widget w5 = new Widget(456l, "ABC234", "PARAGRAPH", 1, "555@Welcome to WebDev!");
//
//        widgets.add(w1);
//        widgets.add(w2);
//        widgets.add(w3);
//        widgets.add(w4);
//        widgets.add(w5);

//    }

    @Autowired
    WidgetRepository repository;

    public List<Widget> findAllWidgets() {
        return (List<Widget>) repository.findAll();
    }

    public List<Widget> findWidgetsForTopic(String tid) {
//        List<Widget> ws = new ArrayList<Widget>();
//        for (Widget widget : this.widgets) {
//            if (widget.getTopicId().equals(tid)) {
//                ws.add(widget);
//            }
//        }
//        return ws;

        return repository.findWidgetsForTopic(tid);
    }

    public Widget createWidget(String tid, Widget widget) {
        widget.setTopicId(tid);

        return repository.save(widget);
//        try {
//            widget.setId(new Date().getTime());
//        } catch (ArithmeticException e) {
//            e.printStackTrace();
//            System.out.println(e.getMessage());
//        }
////        widget.setType("Heading");
////        widget.setSize(1);
//        widgets.add(widget);
//
//        return widget;
    }

    public int updateWidget(String wid, Widget widget) {
        int status = 0;

//        for (int i = 0; i < widgets.size(); ++i) {
//            long widgetId = -1;
//
//            try {
//                widgetId = Long.parseLong(wid);
//            } catch (NumberFormatException e) {
//                e.printStackTrace();
//                System.out.println(e.getMessage());
//            }
//
//            if (widgets.get(i).getId() == widgetId) {
//                widgets.set(i, widget);
//                status = 1;
//            }
//        }

        long widgetId = -1;

        try {
            widgetId = Long.parseLong(wid);
        } catch (NumberFormatException e) {
            e.printStackTrace();
//            System.out.println(e.getMessage());
        }

        Widget originalWidget;
        if (repository.findById(widgetId).isPresent()) {
            originalWidget = repository.findById(widgetId).get();
        } else {
            return status;
        }

        if (widget.getType() != null) originalWidget.setType(widget.getType());
        if (widget.getText() != null) originalWidget.setText(widget.getText());
        if (widget.getSize() != null) originalWidget.setSize(widget.getSize());
        if (widget.getSrc() != null) originalWidget.setSrc(widget.getSrc());
        if (widget.getWidth() != null) originalWidget.setWidth(widget.getWidth());
        if (widget.getHeight() != null) originalWidget.setHeight(widget.getHeight());
        if (widget.getCssClass() != null) originalWidget.setCssClass(widget.getCssClass());
        if (widget.getStyle() != null) originalWidget.setStyle(widget.getStyle());
        if (widget.getValue() != null) originalWidget.setValue(widget.getValue());
        if (widget.getWidgetOrdered() != null) originalWidget.setWidgetOrdered(widget.getWidgetOrdered());

        repository.save(originalWidget);

        status = 1;
        return status;
    }

    public int deleteWidget(String wid) {
        int status = 0;

//        for (int i = 0; i < widgets.size(); ++i) {
//            long widgetId = -1;
//
//            try {
//                widgetId = Long.parseLong(wid);
//            } catch (NumberFormatException e) {
//                e.printStackTrace();
//                System.out.println(e.getMessage());
//            }
//
//            if (widgets.get(i).getId() == widgetId) {
//                widgets.remove(i);
//                status = 1;
//            }
//        }

        long widgetId = -1;

        try {
            widgetId = Long.parseLong(wid);
        } catch (NumberFormatException e) {
            e.printStackTrace();
//            System.out.println(e.getMessage());
            return status;
        }

        try {
            repository.deleteById(widgetId);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return status;
        } catch (EmptyResultDataAccessException e) {
            e.printStackTrace();
            return status;
        }

        status = 1;
        return status;
    }

    public Widget findWidgetById(String wid) {
        for (Widget widget : widgets) {
            long widgetId = -1;

            try {
                widgetId = Long.parseLong(wid);
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
