package com.niraj.cloudvendor.controller;

import com.niraj.cloudvendor.model.CloudVendor;
import com.niraj.cloudvendor.service.CloudVendorSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/cloudvendor")
public class CloudVendorAPIService {
    @Autowired
    private CloudVendorSvc cvs;

    @GetMapping("{vendorId}")
    public CloudVendor getCloudVendorDetails(@PathVariable String vendorId){
        return cvs.findCloudVendorById(vendorId);
    }

    @PostMapping
    public CloudVendor createCloudVendorDetails(@RequestBody CloudVendor cloudVendor){
        return cvs.addCloudVendor(cloudVendor);
    }

    @DeleteMapping("{vendorId}")
    public CloudVendor deleteCloudVendor(@PathVariable String vendorId){
        return cvs.removeCloudVendor(vendorId);
    }

    @PutMapping
    public CloudVendor editCloudVendorDetails(@RequestBody CloudVendor cloudVendor){
        CloudVendor foundVendor = cvs.findCloudVendorById(cloudVendor.getVendorId());
        foundVendor.setVendorName(cloudVendor.getVendorName());
        foundVendor.setVendorAddress(cloudVendor.getVendorAddress());
        foundVendor.setVendorPhoneNumber(cloudVendor.getVendorPhoneNumber());
        return foundVendor;
    }

    @GetMapping("/all")
    public ArrayList<CloudVendor> listAllCloudVendors(){
        return cvs.listAll();
    }
}
