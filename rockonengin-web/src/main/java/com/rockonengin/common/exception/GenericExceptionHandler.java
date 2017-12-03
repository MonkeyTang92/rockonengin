//package com.rockonengin.common.exception;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.util.Date;
//
//
//@ControllerAdvice
//public class GenericExceptionHandler {
//    private final Logger logger = LoggerFactory.getLogger(getClass());
//
//    @ExceptionHandler(Exception.class)
//    public ModelAndView processUnauthenticatedException(HttpServletRequest request, HttpServletResponse response, Exception ex) {
//        ModelAndView modelAndView = new ModelAndView("error");
//        GenericResponseDto<Object> genericResponse = new GenericResponseDto();
//        //设置错误代码
//        String errorCode = ConstantException.UNKNOW_EXCEPTION;
//        if( ex instanceof RockonenginWebException){
//            errorCode=((RockonenginWebException)ex).getErrorCode();
//        }else if( ex.getCause() !=null && ex.getCause() instanceof RockonenginWebException){
//            errorCode=((RockonenginWebException)ex.getCause()).getErrorCode();
//        }
//        genericResponse.setResponseCode(errorCode);
//        //设置错误消息
//        genericResponse.setResponseMessage(ExceptionUtil.getMessage(ex));
//        modelAndView.addObject("timestamp",new Date());
//        modelAndView.addObject("error",ex.getClass());
//        modelAndView.addObject("errorMessage",genericResponse );
//        //打印日志
//        StringBuilder sb = new StringBuilder();
//        sb.append(request.getRequestURI());
//        sb.append(" errorCode:"+errorCode);
//        Object requestParams =  request.getAttribute( "requestParams" );
//        if(requestParams!=null){
//            sb.append( " requestParams:").append( JsonUtil.convertToJson( requestParams ) );
//        }
//        if(isRecordLogError(ex)){
//            logger.error(sb.toString(),ex);
//        }else {
//            logger.warn(sb.toString()+" errorMessage:"+ExceptionUtil.getStackTrace(ex));
//        }
//        return modelAndView;
//    }
//
//    private boolean isRecordLogError(Exception ex){
//        if(ex!=null){
//            if( ex instanceof RockonenginWebException) {
//                RockonenginWebException adminException = (RockonenginWebException)ex;
//                String errorCode = adminException.getErrorCode();
//                if(ConstantException.PERMISSION_EXCEPTION.equals(errorCode)){
//                    return false;
//                }
//            }
//        }
//        return true;
//    }
//
//}
