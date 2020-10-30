/*private _res = "arma3urlfetch" callExtension [
    "SENDRQ",
    [
        "#url=<string/url>",
        "#method=<string/method>"
    ]
];*/

_name = "name";
_martin = "martin";

private _response = [
    "http://localhost:8080/greeting", //the url of an request
    "GET", //the HTTP method; most of the time it is "GET"
     [_name, _martin],
     [_name, _martin],//(optional) parameters of the url request
    true

] call a3uf_common_fnc_request;

hint str _response;


/*_result = "extDB3" callExtension "9:VERSION";
hint format ["Installed extDB3 version: %1", _result];

	_dbcheck = "extDB3" callExtension "9:ADD_DATABASE:conqueror";
		systemChat "extDB3: Connected to Database";
	_protocolCheck = "extDB3" callExtension "9:ADD_DATABASE_PROTOCOL:conqueror:SQL:OurExampleSQLProtocol:TEXT";
	_queryResult = "extDB3" callExtension "0:OurExampleSQLProtocol:SELECT * FROM users";
	hint _queryResult;*/
