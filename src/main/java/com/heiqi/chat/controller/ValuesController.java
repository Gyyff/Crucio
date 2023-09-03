package com.heiqi.chat.controller;

import com.heiqi.chat.entity.User;
import com.heiqi.chat.entity.Values;
import com.heiqi.chat.service.ValuesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user/values")
public class ValuesController {
    private final ValuesService valuesService;

    @Autowired
    public ValuesController(ValuesService valuesService) {
        this.valuesService = valuesService;
    }

    @GetMapping("/getValuesUserByUserId/{UserId}")
    public Values getValuesUserByUserId(@PathVariable("UserId") int UserId) {
        return valuesService.getValuesUserByUserId(UserId);
    }

    @GetMapping("/getValuesUserByValuesId/{ValuesId}")
    public Values getValuesUserByValuesId(@PathVariable("ValuesId") int ValuesId) {
        return valuesService.getValuesUserByValuesId(ValuesId);
    }

    @PostMapping("/insertsValues")
    public void insertsValues(@RequestBody Values values) {
        System.out.println("values = " + values);
        valuesService.insertsValues(values);
    }

    @DeleteMapping("/deleteValuesByUserId/{UserId}")
    public void deleteValuesByUserId(@PathVariable("UserId") int UserId){
        valuesService.deleteValuesByUserId(UserId);
    }
    @DeleteMapping("/deleteValuesByValuesId/{ValuesId}")
    public void deleteValuesByValuesId(@PathVariable("ValuesId") int ValuesId){
        valuesService.deleteValuesByValuesId(ValuesId);
    }


}
