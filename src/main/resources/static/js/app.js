$("#thisWorks").click(function(){
  $.get( "api/works", function( data ) {
    $( "#thisWorksText" ).html( data );
    console.log( "Load was performed." );
  });
});

$("#thisDoesNotWork").click(function(){
  $.get( "api/doesntwork", function( data ) {
    $( "#thisDoesNotWorkText" ).html( data );
    console.log( "Load was performed." );
  });
});
