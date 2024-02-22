function doLike(pid,uid){
	
	console.log(pid+", "+uid);
	
	const d={
		
		pid : pid,
		uid : uid,
		operation : 'like'
		
	}
	
	$.ajax({
		
		url : "likeuser",
		data : d,
		success: function (data, textStatus, jqXHR) {
			 console.log(data);
			 if(data.trim()=='true'){
				 let c = $(".like-counter").html();
				 c++
				 $('.like-counter').html(c);
			 }
			},
	    error: function (jqXHR, textStatus, errorThrown) {
			 console.log(data); 
			}
		
	})
      
}


                      /* dislike*/
                      
    function dodisLike(pdid,udid){
		
		console.log(pdid+" , "+udid);
		
		
		const di={
		
		pdid : pdid,
		udid : udid,
		operation : 'dislike'
	}
      $.ajax({
		  
		  url : "dislikeuser",
		  data : di,
		  success: function (data, textStatus, jqXHR) {
			  console.log(data);
			  if(data.trim()=='true'){
				 let c = $(".dislike-counter").html();
				 c++
				 $('.dislike-counter').html(c);
			 }
			  
			  },
		  error: function (jqXHR, textStatus, errorThrown) {
			 console.log(data); 
			}
		  
	  })		
		

}
		                  
    
