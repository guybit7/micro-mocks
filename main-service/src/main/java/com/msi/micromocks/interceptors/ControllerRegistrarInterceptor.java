package com.msi.micromocks.interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.msi.micromocks.dto.MockItemControllerDTO;
import com.msi.micromocks.dto.MockItemInternalRequestControllerDTO;
import com.msi.micromocks.service.MockItemService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class ControllerRegistrarInterceptor implements HandlerInterceptor {

	@Autowired
	MockItemService mockItemService;
	
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        
    	System.out.println("INSIDE PRE HANDLE");
    	String reqUrl = request.getRequestURI();
    	System.out.println(reqUrl);
    	if (reqUrl.contains("swagger-ui")) {
    		return true;
    	}
    	
    	if (!reqUrl.contains("/api/mock-item")) {
    		MockItemInternalRequestControllerDTO mockItemInternalRequestControllerDTO = new MockItemInternalRequestControllerDTO();
    		mockItemInternalRequestControllerDTO.setEndPoint(reqUrl);
    		
            try {            	

            	System.out.println(mockItemInternalRequestControllerDTO.getEndPoint());
            	MockItemControllerDTO mockItemControllerDTO = mockItemService.getMockItem(mockItemInternalRequestControllerDTO);
            	
                response.setStatus(200);
                
                ObjectMapper objectMapper = new ObjectMapper();
                
                response.getWriter().write(objectMapper.writeValueAsString(mockItemControllerDTO.getValue()));
                
            	return false; // Stop further processing of the request
            } catch (Exception e) {
				// TODO: handle exception
            	e.printStackTrace();
			}
    	}
        return true;
    }
    

}
