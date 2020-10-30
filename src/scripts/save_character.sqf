_player = _this select 1;
_inventory = getUnitLoadout _player;
_inventoryToSend = str _inventory;
hint _inventoryToSend;


_response = [
    "http://localhost:8080/characters/save", //the url of an request
    "POST", //the HTTP method; most of the time it is "GET"
    ["#postData", _inventoryToSend] //(optional) parameters of the url request
] call a3uf_common_fnc_request;

//hint _response;