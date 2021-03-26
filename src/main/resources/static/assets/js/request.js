$(document).ready(function(){
	$('#submit').click(function (e){		
				e.preventDefault();
console.log("hi");
		        fire_ajax_submit();

		    });

		});

	function fire_ajax_submit(){
		var field = document.getElementById("field").value;
		var operator = document.getElementById("operator").value;
		var keyword = document.getElementById("keyword").value;

				$.ajax({
					type: "GET",
					url: "/getDetails",
					data: {
						field : field,							
						operator : operator,
						keyword : keyword
						},
					dataType: "json",
					success: function(data){
						
							if(data != null && data != "")
							{
							var response = "";							
							    for(var i=0;i<data.length;i++)
							    {
							    	response += "\nPerson "+ i+1+"-->" +" \n Name: "+data[i].name+" \n Address: "+data[i].address+" \n Phone Number: "+data[i].phonenumber
							    	             +" \n Salary: "+data[i].salary+" \n Pension: "+data[i].pension;
							    	
							    }
							      		
							      		document.getElementById("results").innerHTML = response;
							      		document.getElementById("resultrow").style.display = "block"			
							}
							else
								{
									document.getElementById("results").innerHTML = "No results match you search";
							      		document.getElementById("resultrow").style.display = "block"	
								}
							
					},
				   error: function () {
			            alert("An error has occured!!!");
			        }
				});
	}

