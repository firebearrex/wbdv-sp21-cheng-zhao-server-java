package com.example.wbdvsp2102chengserverjava.controllers;

import com.example.wbdvsp2102chengserverjava.models.Widget;
import com.example.wbdvsp2102chengserverjava.services.WidgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class WidgetController {
    @Autowired
    WidgetService service;

    @GetMapping("/api/widgets")
    public List<Widget> findAllWidgets() {
        return service.findAllWidgets();
    }

    @GetMapping("/api/topics/{tid}/widgets")
    public List<Widget> findWidgetsForTopic(
            @PathVariable("tid") String topicId
    ) {
        return service.findWidgetsForTopic(topicId);
    }

    @PostMapping("/api/topics/{tid}/widgets")
    public Widget createWidget(
            @PathVariable("tid") String tid,
            @RequestBody Widget widget
    ) {
        return service.createWidget(tid, widget);
    }

    @PutMapping("/api/widgets/{wid}")
    public int updateWidget(
            @PathVariable("wid") String wid,
            @RequestBody Widget widget
    ) {
        return service.updateWidget(wid, widget);
    }

    @DeleteMapping("/api/widgets/{wid}")
    public int deleteWidget(
            @PathVariable("wid") String wid
    ) {
        return service.deleteWidget(wid);
    }

    @GetMapping("/api/widgets/{wid}")
    public Widget findWidgetById(
            @PathVariable("wid") String wid
    ) {
        return service.findWidgetById(wid);
    }
}
