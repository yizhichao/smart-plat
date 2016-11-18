package com.allcam.adapter.common;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Json2Map
{
    
    public Map<String, Object> getMessage(String requestJson)
        throws Exception
    {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> maps = new LinkedHashMap<String, Object>();
        JsonNode node = mapper.readTree(requestJson);
        System.out.println(node);
        Iterator<JsonNode> iterator = node.elements();
        int j = 0;
        while (iterator.hasNext())
        {
            JsonNode nod = iterator.next();
            System.out.println(nod);
            if (j == 0)
            {
                j++;
                continue;
            }
            else
            {
                maps = mapper.readValue(nod.toString(), Map.class);
                break;
            }
        }
        return maps;
    }
}
