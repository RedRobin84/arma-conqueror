// testfile

"ArmaRequests" callExtension "0|GET|http://localhost:8080/greeting";

waitUntil {sleep 1; "ArmaRequests" callExtension "2" == "OK"};

_response = "ArmaRequests" callExtension "1";

_parsedResponse = parseSimpleArray _response;

_code = _parsedResponse select 0;

_data = _parsedResponse select 1;

_test = _data select 0;

systemChat _test;