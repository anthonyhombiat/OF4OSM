/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lig.steamer.of4osm.util;

/**
 *
 * @author amehiris
 */
public enum Property {
            addr,
            attribution, comment, description, email, fax, fixme, image, note, phone,
            source, source_ref, url, todo, website, wikipedia,
            name , int_name, loc_name, nat_name, official_name, old_name, reg_name, short_name,
            sorting_name, alt_name,
            area, bridge, charge, covered, crossing, cutting, disused, drive_through, drive_in,
            electrified,ele, embankment, end_date, est_width, fire_object, fire_operator, fire_rank,
            frequency, inscription, internet_access, layer, leaf_cycle, leaf_type, location, narrow,
            nudism, opening_hours, operator, start_date, service_times, tactile_paving, tidal, tunnel,
            toilets, wheelchair, width,
            iata, icao, int_ref, lcn_ref, loc_ref, nat_ref, ncn_ref, old_ref, rcn_ref, ref, reg_ref,
            access, agricultural, atv, bdouble, bicycle, boat, emergency, foot, forestry, goods,
            hazmat, hgv, horse, inline_skates, lhv, mofa, moped, motorboat, motorcar, motorcycle, motor_vehicle,
            psv, roadtrain,ski, tank, vehicle,
            maxheight , maxlength , maxspeed ,
            maxstay, maxweight, maxwidth, minspeed, noexit, oneway, Relation, toll, traffic_sign,
           fourwd_only  ;

    @Override
    public String toString() {
        if (this == fourwd_only)
            return "4wd_only";
        return super.toString(); 
    }
           
           
                        
}
