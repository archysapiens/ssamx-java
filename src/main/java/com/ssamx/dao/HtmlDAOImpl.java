package com.ssamx.dao;

import org.springframework.stereotype.Repository;

@Repository
public class HtmlDAOImpl implements HtmlDAO{

	@Override
	public String getTopNavBar() {

		
		return  "<h1> Inicia  [fncBuildTopNavBar]</h1>" + 
				" <!-- Inicia  [fncBuildTopNavBar] --> " + 
				
				"	<div id=\"page-wrapper\" class=\"gray-bg dashbard-1\" >" + 
				"        <div class=\"row border-bottom\">" + 
				"        <nav class=\"navbar navbar-static-top\" role=\"navigation\" style=\"margin-bottom: 0\">" + 
				"            <div class=\"navbar-header\">" + 
				"                <a class=\"navbar-minimalize minimalize-styl-2 btn btn-primary\" href=\"#\">" + 
				"                    <i class=\"fa fa-bars\"></i> " + 
				"                </a>" + 
				"            </div>" + 
				"            <ul class=\"nav navbar-top-links navbar-right\">" + 
				"                <li>" + 
				"                    <span class=\"m-r-sm text-muted welcome-message\">" + 
				"                    Sistema de Recepción de Productos de Nómina</span>" + 
				"                </li>" + 
				"              <li class=\"dropdown\">" + 
				"                " + 
				"                    <a id=\"buttonLockScreen\" class=\"dropdown-toggle count-info\" data-toggle=\"dropdown\" href=\"#\">" + 
				"                        <i class=\"fa fa-lock\"></i>  " + 
				"                        <span id=\"num-msgs\" class=\"label label-primary\"></span>" + 
				"                    </a>" + 
				"" + 
				"" + 
				"                </li>" + 
				"" + 
				"" + 
				"                <li class=\"dropdown\">" + 
				"<!--" + 
				"                    <a id=\"enc-num-msgs\" class=\"dropdown-toggle count-info\" data-toggle=\"dropdown\" href=\"#\">" + 
				"                        <i class=\"fa fa-bell\"></i>  " + 
				"                        <span id=\"num-msgs\" class=\"label label-primary\"></span>" + 
				"                    </a>" + 
				"-->" + 
				"" + 
				"                </li>" + 
				"" + 
				"" + 
				"             <!-- SIGN OUT -->" + 
				"      <li class=\"xn-icon-button pull-right\">" + 
				"        <a href=\"#\" class=\"mb-control\" data-box=\"#mb-signout\"><span class=\"fa fa-sign-out\"></span> Salir</a>                        " + 
				"      </li> " +
				 "<h1> Inicia  [fncBuildTopNavBar]</h1>" + 
				" <!-- Inicia  [fncBuildTopNavBar] --> " 
				;
	}
	
	

}
