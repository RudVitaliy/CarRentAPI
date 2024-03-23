API Documentation
This documentation provides details about the RESTful API endpoints available for managing users, vehicles, and vehicle rentals.
User Management
Retrieve All Clients
* URL: /api/v1/user
* Method: GET
* Description: Retrieves all clients registered in the system.
* Response Body: List of UserDto objects representing all clients.
    * Response Status Codes:
    * 200 OK: Successful operation.
Retrieve All Rentals of a Specific Client
* URL: /api/v1/user/rentals/{id}
* Method: GET
* Description: Retrieves all rentals of a specific client identified by their ID.
    * Parameters:
    * id (path parameter): ID of the client whose rentals are to be retrieved.
* Response Body: List of VehicleRentalDto objects representing all rentals of the specified client. If the client ID does not exist or has no rentals, an empty list will be returned.
    * Response Status Codes:
    * 200 OK: Successful operation.
Register a New Client
* URL: /api/v1/user/register
* Method: POST
* Description: Registers a new client in the system.
* Request Body: UserDto object representing the client to be registered.
    * Response Status Codes:
    * 200 OK: Successful registration.
    * 400 Bad Request: If there are validation errors in the request body.
Vehicle Management
Register a New Vehicle
* URL: /api/v1/vehicle/register
* Method: POST
* Description: Registers a new vehicle in the system.
* Request Body: VehicleDto object representing the vehicle to be registered.
    * Response Status Codes:
    * 200 OK: Successful registration.
    * 400 Bad Request: If there are validation errors in the request body.
Delete a Vehicle
* URL: /api/v1/vehicle/delete/{id}
* Method: DELETE
* Description: Deletes a vehicle from the system based on its ID.
    * Parameters:
    * id (path parameter): ID of the vehicle to be deleted.
    * Response Status Codes:
    * 200 OK: Successful deletion.
    * 404 Not Found: If the specified vehicle ID does not exist.
Update Details of a Vehicle
* URL: /api/v1/vehicle/update/{id}
* Method: PATCH
* Description: Updates details of a vehicle identified by its ID.
    * Parameters:
    * id (path parameter): ID of the vehicle to be updated.
* Request Body: VehicleDto object representing the updated details of the vehicle.
    * Response Status Codes:
    * 200 OK: Successful update.
    * 400 Bad Request: If there are validation errors in the request body.
    * 404 Not Found: If the specified vehicle ID does not exist.
Vehicle Rental Management
Rent a Vehicle
* URL: /api/v1/rent
* Method: POST
* Description: Handles the rental of a vehicle by a client.
    * Parameters:
    * client_id (query parameter): ID of the client renting the vehicle.
    * vehicle_id (query parameter): ID of the vehicle to be rented.
    * Response Status Codes:
    * 200 OK: Successful rental.
    * 404 Not Found: If either the specified client ID or vehicle ID does not exist.
    * 
Custom Error Responses
    * Entity Not Found Error:
    * Response Body Format:json  { "message": "The requested entity was not found.", "timestamp": "current_timestamp" }   
    * Response Status Code: 404 Not Found
    * Entity Not Created Error:
    * Response Body Format:json   { "message": "One or more fields failed validation.", "timestamp": "current_timestamp" }   
    * Response Status Code: 400 Bad Request
    * 

