package com.nikolas.leaflet.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import com.nikolas.leaflet.domain.CentroVacunacion;
import com.nikolas.leaflet.service.CentroVacunacionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.slf4j.Marker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.nikolas.leaflet.domain.LeafletMap;
import com.nikolas.leaflet.service.LeafletMapService;
import com.nikolas.leaflet.util.GenericResponse;


@Controller
@RequestMapping("/map")
public class LeafletMapController {
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	LeafletMapService leafletMapService;

	@Autowired
	CentroVacunacionService centroVacunacionService;
	
	@RequestMapping(value = "/index")
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		logger.info("Returning hello view with ");
		Map<String, Object> myModel = new HashMap<String, Object>();

		final LeafletMap  leafletMap = this.leafletMapService.leafletMap(2);
		myModel.put("map", leafletMap);
		ModelAndView mav = new ModelAndView();
		List<CentroVacunacion> cvList = this.centroVacunacionService.centroVacunacionGetAll();
		mav.addObject("centros",cvList);
		mav.addObject("model",myModel);
		return mav;

	}
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public GenericResponse registerUserAccount(@Valid final LeafletMap leafletMap, final HttpServletRequest request) {
    	logger.debug("Registering user account with information: {}",leafletMap);
    	leafletMapService.updateLeafletMap(leafletMap);
        return new GenericResponse("success");
    }
	@RequestMapping("/personas")
	public ModelAndView ingresarCategoria() {

		ModelAndView mav = new ModelAndView();
		CentroVacunacion cv = this.centroVacunacionService.centroVacunacionGetOne(1);
		mav.addObject("centros",cv);
		mav.setViewName("/map/vpersonasvacunadas");
		return mav;
	}

}
