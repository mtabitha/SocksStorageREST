# SocksStorageREST

Small REST application to automate the accounting of socks in the warehouse of the store. Using **Spring Boot, JPA**.
The storekeeper be able to:
- Take into account the arrival and departure of socks;
- Find out the total number of socks of a certain color and composition at a given time.

## Endpoints

- */api/socks/income*   POST - incoming socks. Required request parameters:
  - color, cottonPart, quantity;
- */api/socks/outcome*  POST - outcoming socks. Required request parameters:
  - color, cottonPart, quantity;
- */api/socks/*         GET - returns the sum of pairs of socks in sorage that match the query parameters:
  - color;
  - operation, indicates which socks to choose regarding parameter *cottonPart* (*moreThan, equal, lessThan*);
  - cottonPart;
