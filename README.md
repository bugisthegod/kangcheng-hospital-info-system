# Woniu HIS (Hospital Information System)

## Project Overview

Woniu HIS is a distributed hospital information management system based on Spring Boot and Spring Cloud, designed with microservices architecture to provide comprehensive hospital business management functionality.

## Technology Stack

- **Backend Framework**: Spring Boot 2.3.7, Spring Cloud Hoxton.SR9
- **Service Governance**: Spring Cloud Alibaba 2.2.5
- **Database**: MyBatis
- **Java Version**: JDK 1.8
- **Build Tool**: Maven

## System Architecture

This project adopts microservices architecture and includes the following core modules:

### Core Service Modules

- **basic-info** - Basic Information Service (Port: 8001)
  - Bed management, department management, equipment management
  - Inspection items and operation items management
  - Ward management and employee information management

- **sso-login** - Single Sign-On Service
  - User authentication and authorization
  - Unified login portal

- **woniu-his-gateway** - API Gateway
  - Service routing and load balancing
  - Unified authentication and rate limiting

- **woniu-his-registered** - Registration Service
  - Patient registration management
  - Appointment slot management

- **woniu-his-outpatient** - Outpatient Service
  - Outpatient treatment management
  - Medical record management

- **woniu-his-charge** - Billing Service
  - Fee calculation and billing management
  - Medical insurance settlement

- **woniu-his-charge-consumer** - Billing Consumer Service
  - Message processing related to billing

- **woniu-his-drug** - Drug Management Service
  - Drug information management
  - Inventory management

- **woniu-his-nurse** - Nursing Management Service
  - Nursing record management
  - Medical order execution

- **woniu-his-common-xj** - Common Components
  - Common utilities and configurations

## Project Structure

```
woniu-his/
├── basic-info/                    # Basic Information Service
├── sso-login/                     # Single Sign-On Service
├── woniu-his-charge/              # Billing Service
├── woniu-his-charge-consumer/     # Billing Consumer Service
├── woniu-his-common-xj/           # Common Components
├── woniu-his-drug/                # Drug Management Service
├── woniu-his-gateway/             # API Gateway
├── woniu-his-nurse/               # Nursing Management Service
├── woniu-his-outpatient/          # Outpatient Service
├── woniu-his-registered/          # Registration Service
└── pom.xml                        # Parent Maven Configuration
```

## Quick Start

### Requirements

- JDK 1.8+
- Maven 3.6+
- MySQL 5.7+
- Redis (Optional, for caching)

### Build and Run

1. **Clone the project**
   ```bash
   git clone <repository-url>
   cd woniu-his
   ```

2. **Compile the project**
   ```bash
   mvn clean compile
   ```

3. **Package the project**
   ```bash
   mvn clean package
   ```

4. **Run services**
   
   Each service can be started independently. Recommended startup order:
   
   ```bash
   # 1. Start registry and configuration center (if used)
   # 2. Start gateway service
   java -jar woniu-his-gateway/target/woniu-his-gateway-*.jar
   
   # 3. Start basic services
   java -jar basic-info/target/basic-info-*.jar
   java -jar sso-login/target/sso-login-*.jar
   
   # 4. Start business services
   java -jar woniu-his-registered/target/woniu-his-registered-*.jar
   java -jar woniu-his-outpatient/target/woniu-his-outpatient-*.jar
   java -jar woniu-his-charge/target/woniu-his-charge-*.jar
   # ... other services
   ```

### Configuration

Each service has independent configuration files located in their respective `src/main/resources` directories:

- `application.yml` - Main configuration file
- `application-dev.yml` - Development environment configuration
- `application-test.yml` - Test environment configuration
- `bootstrap.yaml` - Bootstrap configuration

Please modify database connections, registry addresses, and other configurations according to your actual environment.

## Main Features

- ✅ Patient registration and appointment management
- ✅ Outpatient treatment and electronic medical records
- ✅ Inpatient management and bed allocation
- ✅ Drug management and prescription handling
- ✅ Billing management and medical insurance settlement
- ✅ Nursing management and medical order execution
- ✅ Basic information maintenance (departments, employees, equipment, etc.)
- ✅ Unified identity authentication and permission management

## Development Standards

- Follow Alibaba Java Development Guidelines
- Use RESTful API design
- Unified exception handling and logging
- Complete code comments and standardized method naming

## Contributing

1. Fork this project
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Create a Pull Request

## License

This project is licensed under the [MIT License](LICENSE).

## Contact

If you have questions or suggestions, please contact us through:

- Project Issues: [Submit Issue](../../issues)
- Email: [your-email@example.com]

---

**Note**: This is a demo project. Please adjust configurations and features according to your actual needs.