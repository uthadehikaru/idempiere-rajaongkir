# iDempiere RajaOngkir Plugin

## Overview
The iDempiere RajaOngkir Plugin integrates the RajaOngkir shipping cost API with the iDempiere ERP system. This plugin allows users to calculate shipping costs directly within iDempiere based on the RajaOngkir service.

## Features
- Calculate shipping costs using RajaOngkir API
- Support for multiple couriers
- Integration with iDempiere order and shipment processes
- Configurable API key and settings

## Installation
1. Download the plugin JAR file from the [releases page](https://github.com/uthadehikaru/idempiere-rajaongkir/releases/).
2. Upload jar via felix console.
3. Restart the iDempiere server.

## Configuration
1. Login as System
2. Navigate to the `System Configurator` window in iDempiere.
3. Add a new configuration with the following details:
    - **Name**: RAJAONGKIR_API_KEY
    - **Configured Value**: <Your RajaOngkir API key>
4. Save the configuration.

if your rajaongkir account type is pro, add this additional system configurator. if not, skip to step 7
5. Add a new configuration with the following details:
    - **Name**: RAJAONGKIR_ACCOUNT_TYPE
    - **Configured Value**: pro
6. Save the configuration.

7. Run process "Sync RajaOngkir Data"

## Usage
- Menu "Check RajaOngkir Cost"
this process to get cost for local courier within indonesia teritory

- Menu "Check International Cost"
this process to get cost for international courier around the world

- Menu "Tracking Package"
this process to tracking waybill courier

- Menu "International Destination"
this window to maintain international destination that supported by raja ongkir

- Menu "RajaOngkir Courier"
this window to maintain couriers that supported by raja ongkir

## Support
For issues and feature requests, please visit the [issue tracker](https://github.com/uthadehikaru/idempiere-rajaongkir/issues).

## License
This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Acknowledgements
- [RajaOngkir](https://rajaongkir.com) for providing the shipping cost API.
- The iDempiere community for their support and contributions.
