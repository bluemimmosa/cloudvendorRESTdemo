package com.niraj.cloudvendor.service;

import com.niraj.cloudvendor.model.CloudVendor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CloudVendorSvc {
    ArrayList<com.niraj.cloudvendor.model.CloudVendor> cloudVendors;

    public CloudVendorSvc() {
        this.cloudVendors = new ArrayList<>();
    }

    public CloudVendor findCloudVendorById(String vendorId){
        for(CloudVendor cv: cloudVendors){
            if(cv.getVendorId().equalsIgnoreCase(vendorId)){
                return cv;
            }
        }
        return null;
    }

    public CloudVendor addCloudVendor(CloudVendor cloudVendor){
        cloudVendors.add(cloudVendor);
        return this.findCloudVendorById(cloudVendor.getVendorId());
    }

    public ArrayList<CloudVendor> listAll(){
        return this.cloudVendors;
    }

    public int findIndexOfCloudVendor(String vendorId){
        int i=0;
        for(CloudVendor cv: cloudVendors){
            if(cv.getVendorId().equalsIgnoreCase(vendorId)){
                return i;
            }
            i++;
        }
        return -1;
    }

    public CloudVendor removeCloudVendor(String vendorId){
        int indexToRemove = findIndexOfCloudVendor(vendorId);
        if(indexToRemove >= 0)
            return cloudVendors.remove(indexToRemove);
        return null;
    }
}
