/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lig.steamer.of4osm;

import lig.steamer.of4osm.util.openinghours.OpeningHour;

/**
 *
 * @author amehiris
 */
public class TestOpeningHours {
    public static void main(String[] args) throws Exception {
        System.out.println("valide: "+ OpeningHour.isOpeningHours("Mo 9:00-20:00; Fr 11:00-22:00; Sa-Su 11:00-20:00"));
    }
}
