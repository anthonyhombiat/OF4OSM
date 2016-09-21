/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lig.steamer.of4osm;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import lig.steamer.of4osm.ws.taginfo.key.similar.TagInfoKeySimilarResponse;
import lig.steamer.of4osm.ws.taginfo.key.stats.TagInfoKeyStatsResponse;
import lig.steamer.of4osm.ws.taginfo.key.values.TagInfoKeyValuesResponse;
import lig.steamer.of4osm.ws.taginfo.tag.stats.TagInfoTagStatsResponse;
import lig.steamer.of4osm.ws.taginfo.tags.popular.TagInfoTagsPopularResponse;
import lig.steamer.of4osm.ws.taginfo.key.combinations.TagInfoKeyCombinationsResponse;

/**
 *
 * @author amehiris
 */
public class TagInfoApp {

    /**
     * @param args the command line arguments
     * @throws java.net.MalformedURLException
     */
    public static void main(String[] args) throws MalformedURLException, IOException {

        String[] api = {"key/combinations?", "key/similar?", "key/stats?", "key/values?", "tag/stats?", "tags/popular?"};

        //URL JSON to JavaObject
        ObjectMapper objectMapper = new ObjectMapper();

        System.out.println(" Indiquez le domaine de la requète:\n \t Tapez 0 pour \"key/combinations?\" "
                + "\n \t Tapez 1 pour \"key/similar?\""
                + "\n \t Tapez 2 pour \"key/stats?\""
                + "\n \t Tapez 3 pour \"key/values?\""
                + "\n \t Tapez 4 pour \"tag/stats?\""
                + "\n \t Tapez 5 pour \"tags/popular?\"");

        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();

        StringBuilder str = new StringBuilder();
        str.append("https://taginfo.openstreetmap.org/api/4/");

        switch (i) {

            case 0: {
                str.append(api[0]);

                System.out.println("Entrer la clef (Key)");
                String Key = sc.next();
                Key = "key=" + Key;
                str.append(Key);

                System.out.println("Entrer la page");
                int page = sc.nextInt();
                str.append("&page=");
                str.append(page);

                System.out.println("Entrer le nbr de répense par page");
                int rp = sc.nextInt();
                str.append("&rp=");
                str.append(rp);

                URL url = new URL(str.toString());

                TagInfoKeyCombinationsResponse resultat = new TagInfoKeyCombinationsResponse();
                resultat = objectMapper.readValue(url, TagInfoKeyCombinationsResponse.class);
                System.out.println(resultat.toString());
            }
            break;
            case 1: {
                str.append(api[1]);
                System.out.println("Entrer la clef (Key)");
                String Key = sc.next();
                Key = "key=" + Key;
                str.append(Key);

                System.out.println("Entrer la page");
                int page = sc.nextInt();
                str.append("&page=");
                str.append(page);

                System.out.println("Entrer le nbr de répense par page");
                int rp = sc.nextInt();
                str.append("&rp=");
                str.append(rp);
                URL url = new URL(str.toString());

                TagInfoKeySimilarResponse resultat = new TagInfoKeySimilarResponse();
                resultat = objectMapper.readValue(url, TagInfoKeySimilarResponse.class);
                System.out.println(resultat.toString());
            }
            break;
            case 2: {
                str.append(api[2]);

                System.out.println("Entrer la clef (Key)");
                String Key = sc.next();
                Key = "key=" + Key;
                str.append(Key);

                URL url = new URL(str.toString());
                TagInfoKeyStatsResponse resultat = new TagInfoKeyStatsResponse();
                resultat = objectMapper.readValue(url, TagInfoKeyStatsResponse.class);
                System.out.println(resultat.toString());
            }
            break;
            case 3: {
                str.append(api[3]);
                System.out.println("Entrer la clef (Key)");
                String Key = sc.next();
                Key = "key=" + Key;
                str.append(Key);

                System.out.println("Entrer la page");
                int page = sc.nextInt();
                str.append("&page=");
                str.append(page);

                System.out.println("Entrer le nbr de répense par page");
                int rp = sc.nextInt();
                str.append("&rp=");
                str.append(rp);
                URL url = new URL(str.toString());
                TagInfoKeyValuesResponse resultat = new TagInfoKeyValuesResponse();
                resultat = objectMapper.readValue(url, TagInfoKeyValuesResponse.class);
                System.out.println(resultat.toString());
            }
            break;
            case 4: {
                str.append(api[4]);
                System.out.println("Entrer la clef (Key)");
                String Key = sc.next();
                Key = "key=" + Key;
                str.append(Key);
                System.out.println("Entrer la valeur (value)");
                String value = sc.next();
                value = "&value=" + value;
                str.append(value);

                URL url = new URL(str.toString());
                TagInfoTagStatsResponse resultat = new TagInfoTagStatsResponse();
                resultat = objectMapper.readValue(url, TagInfoTagStatsResponse.class);
                System.out.println(resultat.toString());
            }
            break;
            case 5: {
                str.append(api[5]);
                System.out.println("Entrer la page");
                int page = sc.nextInt();
                str.append("page=");
                str.append(page);

                System.out.println("Entrer le nbr de répense par page");
                int rp = sc.nextInt();
                str.append("&rp=");
                str.append(rp);
                
                System.out.println(str);
                URL url = new URL(str.toString());
                TagInfoTagsPopularResponse resultat = new TagInfoTagsPopularResponse();
                resultat = objectMapper.readValue(url, TagInfoTagsPopularResponse.class);
                System.out.println(resultat.toString());
            }
            break;
            default:
                System.out.println("Invalide parametres");
                break;
        }
        System.out.println(str);

    }
    
    

}
