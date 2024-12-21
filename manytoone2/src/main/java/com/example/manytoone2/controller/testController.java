package com.example.manytoone2.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.manytoone2.service.saveService;
import com.example.manytoone2.service.testService;

import lombok.RequiredArgsConstructor;
   
@RestController
@RequiredArgsConstructor
public class testController {
    private final testService testservice;
    private final saveService saveservice;

    @PostMapping("/")
    public void index() {
        System.out.println("index");
        saveservice.save();
    }

    @PostMapping("/getMemberList1")
    public void getMemberList1() {
        testservice.getMemberList1();
    }

    @PostMapping("/getMemberList2")
    public void getMemberList2() {
        testservice.getMemberList2();
    }

    @PostMapping("/getMemberList3")
    public void getMemberList3() {
        testservice.getMemberList3();
    }
}
