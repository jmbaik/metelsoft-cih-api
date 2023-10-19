package metel.cih.api.base;

import metel.cih.api.eunms.ResponseCode;

public class ApiResponse {

    public static <T>ResponseDto<T> Case(String code, String message, T data){
        return new ResponseDto<>(code, message, data);
    }
    public static <T>ResponseDto<T> Success(String message, T data){
        return new ResponseDto<>(ResponseCode.Success.toString(), message, data);
    }
    public static <T>ResponseDto<T> Fail(String message, T data){
        return new ResponseDto<>(ResponseCode.Fail.toString(), message, data);
    }
    public static <T>ResponseDto<T> Error(String message, T data){
        return new ResponseDto<>(ResponseCode.Error.toString(), message, data);
    }

    public static <T>ResponseDto<T> Success(T data){
        return new ResponseDto<>(ResponseCode.Success.toString(), "Success", data);
    }
    public static <T>ResponseDto<T> Fail(T data){
        return new ResponseDto<>(ResponseCode.Success.toString(), "Fail", data);
    }
    public static <T>ResponseDto<T> Error(T data){
        return new ResponseDto<>(ResponseCode.Success.toString(), "Error", data);
    }

}
