package com.heiqi.chat.common;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Result<T>{
    @ApiModelProperty("状态码")
    private Integer code;
    @ApiModelProperty("提示")
    private String msg;
    @ApiModelProperty("数据")
    private Object data;

    public static Result success(){
        return new Result(200,"操作成功",null);
    }
    public static Result success(Object data){
        return new Result(200,"操作成功",data);
    }

    public static Result error(){
        return new Result(400,"失败",null);
    }
    public static Result error(String msg){
        return new Result(400, null,null);
    }


}
