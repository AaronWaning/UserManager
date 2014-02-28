define([
    	"dojo/_base/declare","dojo/dom","dojo/on", "dijit/layout/SplitContainer", "dijit/layout/ContentPane"
    ], function(declare,dom,on,SplitContainer,ContentPane){
    	return declare("IndexLayout",null, {
    		constructor:function(){
    		},
    	    init:function(){
    	    	var rootNode = dojo.byId("content");
    			// add two children
    			var pane1 = rootNode.appendChild(document.createElement('div'));
    			var pane2 = rootNode.appendChild(document.createElement('div'));
    			// set the content. can use xhrGet, also
    			pane1.innerHTML = "Pane one test"; pane2.innerHTML = "Pane two test";
     
    			// should use css, but this works:
    			dojo.style(rootNode,"height","100%");
    			dojo.style(rootNode,"width","100%");
    			dojo.style(rootNode,"border","1px solid #333");
     
    			// make them contentpanes
    			var cp1 = new ContentPane({ sizeShare:20 },pane1);
    			var cp2 = new ContentPane({ sizeShare:80 },pane2);
     
    			// init the splitcontainer
    			var split = new SplitContainer({
    				orientation:"horizontal",
    				sizerWidth:10
    			},rootNode).startup();

    	    },
    	});
    });
