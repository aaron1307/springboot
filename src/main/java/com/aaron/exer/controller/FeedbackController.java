package com.aaron.exer.controller;

import com.aaron.exer.bean.FeedbackBean;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by AaronC on 3/27/2017.
 */

@Controller
public class FeedbackController {

    @RequestMapping(value="feedback")
    public String getFeedbackPage(FeedbackBean feedbackBean){
        return "feedback";
    }

    @RequestMapping(value="feedback", method = RequestMethod.POST)
    public String submitFeedback(@Valid FeedbackBean feedbackBean, BindingResult bindingResult){

        if(bindingResult.hasErrors()) {
            return "feedback";
        }

        return "uploadSuccess";
    }
}
