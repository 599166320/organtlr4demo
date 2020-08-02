grammar ArrayInit;
init : '{' value (',' value)* '}';
value : init
      | INIT
      ;
INIT : [0-9]+;
WS : [\t\r\n]+ -> skip;
///Users/dengzhiqiang/IdeaProjects/organtlr4demo/src/main/java/org/antlr4/demo
///Users/dengzhiqiang/IdeaProjects/organtlr4demo/src/main/resources/ArrayInit.g4
