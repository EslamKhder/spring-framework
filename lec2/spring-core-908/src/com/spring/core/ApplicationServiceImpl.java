package com.spring.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ApplicationServiceImpl {

	/*@Autowired
    private @Qualifier("accountServiceApp") ApplicationService applicationService;

*/
	private  ApplicationService applicationService;
	
	
	@Autowired
    public ApplicationServiceImpl(@Qualifier("accountServiceApp") ApplicationService applicationService) {
		this.applicationService = applicationService;
	}


	/*@Autowired
	public void setApplicationService(@Qualifier("accountServiceApp") ApplicationService applicationService) {
		this.applicationService = applicationService;
	}*/



	public void startApp() {
        applicationService.startApp();
    }
}
