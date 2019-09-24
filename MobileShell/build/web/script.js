/* begin Page */
//JavaScript Calling For display and hide a section
            function ShellFunction() {
                
                    var ele = document.getElementById("toggleText");
                    var text = document.getElementById("displayText");
                    if(ele.style.display == "block") {
                        ele.style.display = "none";
                        text.innerHTML = "Add Another Shell";
                    }
                    else {
                        ele.style.display = "block";
                        text.innerHTML = "Hide Shell";
                    }
               
            }
/* end Page */


