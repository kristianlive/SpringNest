package com.example.springnext.controller;

import com.example.springnext.service.FolderService;
import com.example.springnext.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class FolderController {

    @Autowired
    private FolderService folderService;

    @Autowired
    private UserService userService;

}
