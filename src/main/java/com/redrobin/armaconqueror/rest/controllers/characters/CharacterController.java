package com.redrobin.armaconqueror.rest.controllers.characters;

import com.redrobin.armaconqueror.web.entities.Character;
import com.sun.faces.util.Json;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriUtils;

import java.nio.charset.Charset;

@RestController
@RequestMapping("characters")
public class CharacterController {

    @PostMapping(path = "/loadout/save")
    public void saveCharacter(@RequestBody String inventory) {
        String equipment = inventory;
        String test = UriUtils.decode(inventory,  "UTF-8");
        int a = 1;
    }
}
