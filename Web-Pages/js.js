

 function getXmlHttpRequest(){
                var xmlhttp;
                
                if(window.XMLHttpRequest){
                    xmlhttp = new XMLHttpRequest();
                    
                    
                }else if(window.ActiveXObject){
                    xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
                }else{
                    alert("Browser Doesnt Support Ajax");
                }
                
                return xmlhttp;
            }
            
            
             function loadMarks(id){
                
                //alert(id);
                xmlHttp = getXmlHttpRequest();
                
                if(xmlHttp==null){
                    alert("No AJAX What to Do??");
                }else{
                    xmlHttp.open("post", "createTable", true);
                    xmlHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
                    xmlHttp.send("subid="+id);
                    
                    xmlHttp.onreadystatechange = function(){
                        
                                                
                        if(xmlHttp.readyState == 4 && xmlHttp.status == 200){
                           
                           var response_content= xmlHttp.responseText;
                       
                            var json = JSON.parse(response_content);
                                  
                            for(var i = 0;i<json.length;i++){
                                var schoolName = json[i].schoolName;
                                var grade11 = json[i].grade11;
                                var grade10 = json[i].grade10;
                                var grade9 = json[i].grade9;
                                var subject = json[i].subject;
                               
                                var table = document.getElementById("dis");
                                
                                var row = table.insertRow(table.rows.length);
                        
                                
                                var td1 = row.insertCell(0);
                                var td2 = row.insertCell(1);
                                var td3 = row.insertCell(2);
                                var td4 = row.insertCell(3);
                                var td5 = row.insertCell(4);
                                
                                td1.innerHTML = schoolName;
                                td2.innerHTML = grade11;
                                td3.innerHTML = grade10;
                                td4.innerHTML = grade9;
                                td5.innerHTML = subject;
                                
                            }
                           
                            
        
                        }
                 
                        
                    }
                }
                                  
                                  
            
            
 




