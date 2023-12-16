/**
 * 
 */
 $(function(){
   
   $("#myimg").attr("src","../image/oliver2.jpg");
   
   $("#myimg").hover(function(){
   
   	  $(this).attr("src","../image/oliver.jpg");
   	  
   	},function(){
   	
   	  $(this).attr("src","../image/oliver2.jpg");
   	  
   });

    $("#myimg").click(function(){
        $(this).attr("src","../image/war.jpg");
    });
 });
 
 	