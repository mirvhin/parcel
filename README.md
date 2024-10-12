# Parcel System

_A API that will calculate the cost of delivery of a parcel based on weight and volume_

# Table of contents

- [Tecnology Used](#technology-used)
- [Test API](#test-application)

# Technology Used

[(Back to top)](#table-of-contents)

- Java
- Spring Boot
- Git
- Heroku

# Test API

[(Back to top)](#table-of-contents)

curl --location 'https://protected-ravine-09175-ada18bb724b7.herokuapp.com/api/delivery/calculate' \
--header 'Content-Type: application/json' \
--data '{
"weight": 12.5,
"height": 30,
"width": 20,
"length": 15,
"voucherCode": "DISCOUNT10"
}'
