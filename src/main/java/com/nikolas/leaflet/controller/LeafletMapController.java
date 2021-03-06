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
import com.nikolas.leaflet.domain.PersonaMunicipio;
import com.nikolas.leaflet.domain.PersonaVacunada;
import com.nikolas.leaflet.service.CentroVacunacionService;
import com.nikolas.leaflet.service.PersonaVacunadaService;
import com.sun.xml.internal.ws.policy.sourcemodel.ModelNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.slf4j.Marker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
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

	int contSanMarcos;
	int contSanSalvador;
	int contCiudadDelgado;
	int contMejicanos;
	int contCuscatancingo;

	@Autowired
	LeafletMapService leafletMapService;

	@Autowired
	CentroVacunacionService centroVacunacionService;

	@Autowired
	PersonaVacunadaService personaVacunadaService;

	
	@RequestMapping(value = "/index")
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

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
	public ModelAndView ingresarPersona() {

		contSanMarcos=0;
		contSanSalvador=0;
		contCiudadDelgado=0;
		contMejicanos=0;
		contCuscatancingo=0;

		Map<String, Object> myModel = new HashMap<String, Object>();

		final LeafletMap  leafletMap = this.leafletMapService.leafletMap(2);
		myModel.put("map", leafletMap);
		ModelAndView mav = new ModelAndView();
		List<PersonaVacunada> pvList = this.personaVacunadaService.personaVacunadaGetAll();

		for (int i=0; i<pvList.size(); i++){
			if(pvList.get(i).getMunicipioPersona().equals("San Marcos")){
				contSanMarcos= contSanMarcos +1;
			}
			if(pvList.get(i).getMunicipioPersona().equals("San Salvador")){
				contSanSalvador = contSanSalvador +1;
			}
			if(pvList.get(i).getMunicipioPersona().equals("Ciudad Delgado")){
				contCiudadDelgado = contCiudadDelgado +1;
			}
			if(pvList.get(i).getMunicipioPersona().equals("Mejicanos")){
				contMejicanos = contMejicanos +1;
			}
			if(pvList.get(i).getMunicipioPersona().equals("Cuscatancingo")){
				contCuscatancingo = contCuscatancingo +1;
			}


		}
		List<PersonaMunicipio> listaPersonaMunicipio = new ArrayList<>();
		listaPersonaMunicipio.add(new PersonaMunicipio("San Marcos",contSanMarcos));
		listaPersonaMunicipio.add(new PersonaMunicipio("San Salvador",contSanSalvador));
		listaPersonaMunicipio.add(new PersonaMunicipio("Ciudad Delgado",contCiudadDelgado));
		listaPersonaMunicipio.add(new PersonaMunicipio("Mejicanos",contMejicanos));
		listaPersonaMunicipio.add(new PersonaMunicipio("Cuscatancingo",contCuscatancingo));
		mav.addObject("personas",listaPersonaMunicipio);
		//mav.addObject("personas",pvList);
		mav.addObject("model",myModel);
		mav.setViewName("/map/vpersonasvacunadas");
		return mav;
	}

	@RequestMapping("/ipersonas")
	public ModelAndView personaVacunada(){
		ModelAndView mav = new ModelAndView();
		PersonaVacunada personaVacunada = new PersonaVacunada();
		mav.addObject("personaVacunada",personaVacunada);
		mav.setViewName("/map/ingresarPersonaVacunada");
		return mav;
	}
	@RequestMapping("/inpersonas")
	public ModelAndView inPersonaVacunada(@Valid @ModelAttribute PersonaVacunada personaVacunada, BindingResult result){
		ModelAndView mav = new ModelAndView();
		contSanMarcos=0;
		contSanSalvador=0;
		contCiudadDelgado=0;
		contMejicanos=0;
		contCuscatancingo=0;
		if(result.hasErrors()){
			mav.setViewName("/map/ingresarPersonaVacunada");
		}else{
			this.personaVacunadaService.insert(personaVacunada);
			Map<String, Object> myModel = new HashMap<String, Object>();

			final LeafletMap  leafletMap = this.leafletMapService.leafletMap(2);
			myModel.put("map", leafletMap);
			List<PersonaVacunada> pvList = this.personaVacunadaService.personaVacunadaGetAll();
			for (int i=0; i<pvList.size(); i++){
				if(pvList.get(i).getMunicipioPersona().equals("San Marcos")){
					contSanMarcos++;
				}
				if(pvList.get(i).getMunicipioPersona().equals("San Salvador")){
					contSanSalvador++;
				}
				if(pvList.get(i).getMunicipioPersona().equals("Ciudad Delgado")){
					contCiudadDelgado = contCiudadDelgado +1;
				}
				if(pvList.get(i).getMunicipioPersona().equals("Mejicanos")){
					contMejicanos = contMejicanos +1;
				}
				if(pvList.get(i).getMunicipioPersona().equals("Cuscatancingo")){
					contCuscatancingo = contCuscatancingo +1;
				}

			}
			List<PersonaMunicipio> listaPersonaMunicipio = new ArrayList<>();
			listaPersonaMunicipio.add(new PersonaMunicipio("San Marcos",contSanMarcos));
			listaPersonaMunicipio.add(new PersonaMunicipio("San Salvador",contSanSalvador));
			listaPersonaMunicipio.add(new PersonaMunicipio("Ciudad Delgado",contCiudadDelgado));
			listaPersonaMunicipio.add(new PersonaMunicipio("Mejicanos",contMejicanos));
			listaPersonaMunicipio.add(new PersonaMunicipio("Cuscatancingo",contCuscatancingo));
			mav.addObject("personas",listaPersonaMunicipio);
			mav.addObject("model",myModel);
			mav.setViewName("/map/vpersonasvacunadas");
		}
		return mav;
	}


}
