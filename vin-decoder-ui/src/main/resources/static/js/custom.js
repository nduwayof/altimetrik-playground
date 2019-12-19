$(document).ready( function () {
    $('table.data').DataTable();

    setTimeout(function () {
        const country = $('#country-name').text();
        $('#map').show('fast', function () {
            $(this).append('<iframe width="600" height="450" frameborder="0" style="border:0" src="https://www.google.com/maps/embed/v1/place?q='+country+'&key=AIzaSyAohNbXKpZKvgSeR02TC6BVjRUyLiv-1tA" allowfullscreen></iframe>');
        });
    }, 200);
});
