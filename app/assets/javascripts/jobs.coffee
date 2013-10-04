jQuery ($) ->

console.log("coffee is served....")

$table = $('.container table')
JobListUrl = $table.data('list')

progress = '<div class="progress progress-striped active"><div class="bar" style="width: 0%;"></div></div>'
 
loadJobTable = -> 
	$.get JobListUrl, (jobs) ->
		$.each jobs, (id, job) ->
 			row = $('<tr/>')
 			row.append $('<td/>').text(job.id)
 			row.append $('<td/>').text(job.userId)
 			row.append $('<td/>').text(job.nthFibonacci)
 			row.append $('<td/>').html(progress)
 			$table.append row


loadJobTable()



 
