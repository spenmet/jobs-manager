jQuery ($) ->

console.log("coffee is served....")

$table = $('.container table')
JobListUrl = $table.data('list')


  
 
loadJobTable = -> 
	$.get JobListUrl, (jobs) ->
		$.each jobs, (id, job) ->
 			row = $('<tr/>')
 			row.append $('<td/>').text(job.id)
 			row.append $('<td/>').text(job.userId)
 			row.append $('<td/>').text(job.nthFibonacci)
 			
 			button = $('<div class="bar"/>')
 			button.css({"width":job.progress+"%"})
 			progress = $('<div/>')
 			progress.addClass("progress")
 			if job.progress < 100 
 			  progress.addClass("progress-striped active")
 			progress.append(button)
 			
 			row.append $('<td/>').append(progress)
 			$table.append row


loadJobTable()



 
