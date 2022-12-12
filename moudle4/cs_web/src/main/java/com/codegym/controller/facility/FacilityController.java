package com.codegym.controller.facility;

import com.codegym.dto.facility.FacilityDto;
import com.codegym.model.facility.Facility;
import com.codegym.model.facility.FacilityType;
import com.codegym.service.facility.IFacilityService;
import com.codegym.service.facility.IFacilityTypeService;
import com.codegym.service.facility.IRentTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/facility")
public class FacilityController {
    private final IFacilityService facilityService;
    private final IFacilityTypeService facilityTypeService;
    private final IRentTypeService rentTypeService;

    public FacilityController(IFacilityService facilityService, IFacilityTypeService facilityTypeService, IRentTypeService rentTypeService) {
        this.facilityService = facilityService;
        this.facilityTypeService = facilityTypeService;
        this.rentTypeService = rentTypeService;
    }

    @GetMapping("")
    public String display(@Validated FacilityDto tempFacilityDto, BindingResult bindingResultTemp, @Validated FacilityDto editFacilityDto, BindingResult bindingResultEdit, Model model, @RequestParam(defaultValue = "") String searchName, @RequestParam(defaultValue = "-1") int searchFacilityType, @PageableDefault(size = 5) Pageable pageable) {
        if (searchFacilityType != -1) {
            FacilityType facilityType = facilityTypeService.findById(searchFacilityType);
            model.addAttribute("facilityList", facilityService.findByNameContainingAndFacilityType(searchName, facilityType, pageable));
        } else {
            model.addAttribute("facilityList", facilityService.findByNameContaining(searchName, pageable));
        }

        model.addAttribute("searchName", searchName);
        model.addAttribute("searchFacilityType", searchFacilityType);
        model.addAttribute("facilityTypeList", facilityTypeService.findAll());
        model.addAttribute("rentTypeList", rentTypeService.findAll());
        model.addAttribute("tempFacilityDto", FacilityDto.builder().build());
        model.addAttribute("editFacilityDto", FacilityDto.builder().build());

        return "facility/display";
    }

    @PostMapping("save/{saveCode}")
    public String save(@PathVariable String saveCode, @Validated @ModelAttribute("tempFacilityDto") FacilityDto tempFacilityDto, BindingResult bindingResultTemp, @Validated @ModelAttribute("editFacilityDto") FacilityDto editFacilityDto, BindingResult bindingResultEdit, Model model, @RequestParam(defaultValue = "") String searchName, @RequestParam(defaultValue = "-1") int searchFacilityType, @PageableDefault(size = 5) Pageable pageable) {
        Facility facility = Facility.builder().build();
        if (searchFacilityType != -1) {
            FacilityType facilityType = facilityTypeService.findById(searchFacilityType);
            model.addAttribute("facilityList", facilityService.findByNameContainingAndFacilityType(searchName, facilityType, pageable));
        } else {
            model.addAttribute("facilityList", facilityService.findByNameContaining(searchName, pageable));
        }

        model.addAttribute("searchName", searchName);
        model.addAttribute("searchFacilityType", searchFacilityType);
        model.addAttribute("facilityTypeList", facilityTypeService.findAll());
        model.addAttribute("rentTypeList", rentTypeService.findAll());

        switch (saveCode) {
            case "1":
                if (bindingResultTemp.hasErrors()) {
                    model.addAttribute("tempFacilityDto", tempFacilityDto);
                    model.addAttribute("hasErrorsAdd", true);
                    model.addAttribute("statusCode", 1);
                    model.addAttribute("editFacilityDto", FacilityDto.builder().build());
                    return "facility/display";
                }
                BeanUtils.copyProperties(tempFacilityDto, facility);
                facilityService.save(facility);
                return "redirect:/facility";
            case "2":
                if (bindingResultEdit.hasErrors()) {
                    model.addAttribute("tempFacilityDto", FacilityDto.builder().build());
                    model.addAttribute("hasErrorsEdit", true);
                    model.addAttribute("statusCode", 2);
                    model.addAttribute("editFacilityDto", editFacilityDto);
                    return "facility/display";
                }
                BeanUtils.copyProperties(tempFacilityDto, facility);
                facilityService.save(facility);
                return "redirect:/facility";
        }
        return "facility/display";
    }
}
