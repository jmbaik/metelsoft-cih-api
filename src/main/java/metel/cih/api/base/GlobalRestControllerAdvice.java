/*
package metel.cih.api.base;

import metel.cih.api.eunms.ResponseCode;
import org.postgresql.util.PSQLException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(basePackages = "metel.cih.api")
public class GlobalRestControllerAdvice {
    @ExceptionHandler(PSQLException.class)
    public ResponseDto<?> handlePSqlException(PSQLException psqlException) {
        return new ResponseDto<>(
                ResponseCode.Error.toString(),
                "시스템에 문제가 발생하여 작업을 완료하지 못했습니다.\n관리자에게 문의하시길 바랍니다.",
                "org.postgresql.util.PSQLException 발생"
        );
    }

    @ExceptionHandler(Exception.class)
    public ResponseDto<?> handleException(Exception exception) {
        return new ResponseDto<>(
                ResponseCode.Error.toString(),
                "시스템에 문제가 발생하여 작업을 완료하지 못했습니다.\n관리자에게 문의하시길 바랍니다.",
                exception.getMessage()
        );
    }
}
*/
