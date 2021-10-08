<jsp:include page="/WEB-INF/views/header.jsp">
	<jsp:param name="title" value="Add User"/>
</jsp:include>

<div class="flex justify-center">
	<form class="w-full max-w-lg" action="/add-user" method="post">
	
		<!-- 2 COLUMNS -->
		<div class="flex flex-wrap -mx-3 mb-6">
			<div class="w-full md:w-1/2 px-3 mb-6 md:mb-0">
				
				<label class="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2" for="grid-first-name">
					First Name
				</label>
				<input
					class="appearance-none block w-full bg-gray-200 text-gray-700 border border-red-500 rounded py-3 px-4 mb-3 leading-tight focus:outline-none focus:bg-white"
					id="grid-first-name" type="text" placeholder="Jane" name = "fname" required>
				<p class="text-red-500 text-xs italic">Please fill out this field.</p>
	
			</div>
			<div class="w-full md:w-1/2 px-3">
				
				<label class="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2" for="grid-last-name">
					Last Name
				</label>
				<input
					class="appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500"
					id="grid-last-name" type="text" placeholder="Doe" name = "lname" required>
	
			</div>
		</div>
	
		<!-- 1 COLUMN -->
		<div class="flex flex-wrap -mx-3 mb-6">
			<div class="w-full px-3">
				
				<label class="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2" for="grid-password">
					Email
				</label>
				<input
					class="appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 mb-3 leading-tight focus:outline-none focus:bg-white focus:border-gray-500"
					id="grid-password" type="email" placeholder="user@example.com" name = "email" required>
					<p class="text-red-500 text-xs italic">Please fill out this field.</p>
	
			</div>
		</div>
	
		<!-- 2 COLUMNS -->
		<div class="flex flex-wrap -mx-3 mb-6">
			<div class="w-full md:w-1/2 px-3 mb-6 md:mb-0">
				
				<label class="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2" for="grid-first-name">
					Password
				</label>
				<input
					class="appearance-none block w-full bg-gray-200 text-gray-700 border border-red-500 rounded py-3 px-4 mb-3 leading-tight focus:outline-none focus:bg-white"
					id="grid-first-name" type="password" placeholder="******************" name = "password" required>
					<p class="text-gray-600 text-xs italic">Make it as long and as crazy as you'd like</p>
	
			</div>
			<div class="w-full md:w-1/2 px-3">
				
				<label class="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2" for="grid-last-name">
					Retype Password
				</label>
				<input
					class="appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500"
					id="grid-last-name" type="password" placeholder="******************" name = "re-password" required>
	
			</div>
		</div>
	
		<!-- 2 COLUMNS -->
		<!-- <div class="flex flex-wrap -mx-3 mb-6">
			<div class="w-full px-3">
				
				<label class="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2" for="grid-password">
					Password
				</label>
				<input
					class="appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 mb-3 leading-tight focus:outline-none focus:bg-white focus:border-gray-500"
					id="grid-password" type="password" placeholder="******************">
				<p class="text-gray-600 text-xs italic">Make it as long and as crazy as you'd like</p>
	
			</div>
		</div> -->
	
		<div class="flex flex-wrap -mx-3 mb-2">
			<div class="w-full md:w-1/3 px-3 mb-6 md:mb-0">
				<label class="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2" for="grid-city">
					Mobile
				</label>
				<input
					class="appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500"
					id="grid-city" type="number" placeholder="07xxxxxxxx" name="mobile" required>
			</div>
	
			<div class="w-full md:w-1/3 px-3 mb-6 md:mb-0">
				<label class="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2" for="grid-city">
					Address
				</label>
				<input
					class="appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500"
					id="grid-city" type="text" placeholder="Colombo" name="address" required>
			</div>
			
			<div class="w-full md:w-1/3 px-3 mb-6 md:mb-0">
				<label class="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2" for="grid-city">
					NIC
				</label>
				<input
					class="appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500"
					id="grid-city" type="text" placeholder="98xxxxxxxV" name="NIC" required>
			</div>
	
			<!-- <div class="w-full md:w-1/3 px-3 mb-6 md:mb-0">
				<label class="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2" for="grid-state">
					State
				</label>
				<div class="relative">
					<select
						class="block appearance-none w-full bg-gray-200 border border-gray-200 text-gray-700 py-3 px-4 pr-8 rounded leading-tight focus:outline-none focus:bg-white focus:border-gray-500"
						id="grid-state">
						<option>New Mexico</option>
						<option>Missouri</option>
						<option>Texas</option>
					</select>
					<div class="pointer-events-none absolute inset-y-0 right-0 flex items-center px-2 text-gray-700">
						<svg class="fill-current h-4 w-4" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20">
							<path d="M9.293 12.95l.707.707L15.657 8l-1.414-1.414L10 10.828 5.757 6.586 4.343 8z" />
						</svg>
					</div>
				</div>
			</div>
			<div class="w-full md:w-1/3 px-3 mb-6 md:mb-0">
				<label class="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2" for="grid-zip">
					Zip
				</label>
				<input
					class="appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500"
					id="grid-zip" type="text" placeholder="90210">
			</div> -->
		</div>
	
		<!-- 1 COLUMN -->
		<div class="flex flex-wrap -mx-3 mb-6">
			<div class="w-full px-3">
				<label class="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2" for="grid-state">
					Role
				</label>
				<div class="relative">
					<select
						class="block appearance-none w-full bg-gray-200 border border-gray-200 text-gray-700 py-3 px-4 pr-8 rounded leading-tight focus:outline-none focus:bg-white focus:border-gray-500"
						id="grid-state" name="role" required>
						<option value="event_manager">Event Manager</option>
						<option value="attendee">Attendee</option>
					</select>
					<div class="pointer-events-none absolute inset-y-0 right-0 flex items-center px-2 text-gray-700">
						<svg class="fill-current h-4 w-4" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20">
							<path d="M9.293 12.95l.707.707L15.657 8l-1.414-1.414L10 10.828 5.757 6.586 4.343 8z" />
						</svg>
					</div>
				</div>
			</div>
		</div>
		
		<button type="submit" class="btn btn-primary block w-full border border-red-500 rounded py-3 px-4 mb-3 leading-tight focus:outline-none focus:bg-white">Sign Up</button>
		
		<p class="text-red-500 text-xs italic">Alredy have an account?</p>
		<a class="btn btn-secondary btn-sm block w-full border border-red-500 rounded py-3 px-4 mb-3 leading-tight focus:outline-none focus:bg-white" href="/login">Login</a>
	
	</form>
</div>


<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>