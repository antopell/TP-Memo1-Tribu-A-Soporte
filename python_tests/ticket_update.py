import unittest
import requests

class SwaggerAPITestCase(unittest.TestCase):
    def setUp(self):
        self.base_url = "https://tp-memo1-tribu-a-soporte.onrender.com"  # Replace with the actual base URL

    def test_001_create_ticket_with_product_version_and_client(self):
        # Given product, version, and client
        payload = {
            "codigo": "2",
            "titulo": "Google",
            "severidad": "S1",
            "prioridad": "ALTA",
            "estado": "PENDIENTE",
            "description": "string",
            "fechaLimite": "2023-06-28T03:00:00.000+00:00",
            "fechaCreacion": "2023-06-20T21:15:51.375+00:00",
            "cliente": 16,
            "versionProducto": 3
        }

        # When trying to create the ticket
        response = requests.post(f'{self.base_url}/tickets', json=payload)

        # Then ticket is created
        self.assertEqual(response.status_code, 201)
        self.assertEqual(response.json(), {
            "codigo": "2",
            "titulo": "Google",
            "severidad": "S1",
            "prioridad": "ALTA",
            "estado": "PENDIENTE",
            "description": "string",
            "fechaLimite": "2023-06-28T03:00:00.000+00:00",
            "fechaCreacion": "2023-06-20T21:15:51.375+00:00",
            "cliente": 16,
            "versionProducto": 3
        })

    def test_002_get_ticket_info_by_id(self): 
        # Given a ticket id
        codigo = "2"
        # When trying to get the ticket info
        response = requests.get(f'{self.base_url}/tickets/{codigo}')
        # Then ticket info is returned
        self.assertEqual(response.status_code, 200)
        self.assertEqual(response.json(), {
            "codigo": "2",
            "titulo": "Google",
            "severidad": "S1",
            "prioridad": "ALTA",
            "estado": "PENDIENTE",
            "description": "string",
            "fechaLimite": "2023-06-28T03:00:00.000+00:00",
            "fechaCreacion": "2023-06-20T21:15:51.375+00:00",
            "cliente": 16,
            "versionProducto": 3
        })


    def test_003_update_ticket_severity_success(self):
        payload = {
            "codigo": "2",
            "titulo": "Google",
            "severidad": "S4",
            "prioridad": "ALTA",
            "estado": "PENDIENTE",
            "description": "string",
            "fechaLimite": "2023-06-28T03:00:00.000+00:00",
            "fechaCreacion": "2023-06-20T21:15:51.375+00:00",
            "cliente": 16,
            "versionProducto": 3
        }

        id = "2"
        response = requests.put(f'{self.base_url}/tickets/{id}?id={id}', json=payload)
        self.assertEqual(response.status_code, 200)  # Assuming the successful status code is 200
        self.assertEqual(response.json(), payload)

    def test_004_update_ticket_priority_success(self): 
        payload = {
            "codigo": "2",
            "titulo": "Google",
            "severidad": "S4",
            "prioridad": "BAJA",
            "estado": "PENDIENTE",
            "description": "string",
            "fechaLimite": "2023-06-28T03:00:00.000+00:00",
            "fechaCreacion": "2023-06-20T21:15:51.375+00:00",
            "cliente": 16,
            "versionProducto": 3
        }

        id = "2"
        response = requests.put(f'{self.base_url}/tickets/{id}?id={id}', json=payload)
        self.assertEqual(response.status_code, 200)  # Assuming the successful status code is 200
        self.assertEqual(response.json(), payload)

    def test_005_update_ticket_title_success(self):
        payload = {
            "codigo": "2",
            "titulo": "Google Update",
            "severidad": "S4",
            "prioridad": "BAJA",
            "estado": "PENDIENTE",
            "description": "string",
            "fechaLimite": "2023-06-28T03:00:00.000+00:00",
            "fechaCreacion": "2023-06-20T21:15:51.375+00:00",
            "cliente": 16,
            "versionProducto": 3
        }

        id = "2"
        response = requests.put(f'{self.base_url}/tickets/{id}?id={id}', json=payload)
        self.assertEqual(response.status_code, 200)  # Assuming the successful status code is 200
        self.assertEqual(response.json(), payload)

    def test_006_update_ticket_description_success(self):
        payload = {
            "codigo": "2",
            "titulo": "Google Update",
            "severidad": "S4",
            "prioridad": "BAJA",
            "estado": "PENDIENTE",
            "description": "... Doesn't work...",
            "fechaLimite": "2023-06-28T03:00:00.000+00:00",
            "fechaCreacion": "2023-06-20T21:15:51.375+00:00",
            "cliente": 16,
            "versionProducto": 3
        }

        id = "2"
        response = requests.put(f'{self.base_url}/tickets/{id}?id={id}', json=payload)
        self.assertEqual(response.status_code, 200)  # Assuming the successful status code is 200
        self.assertEqual(response.json(), payload)

    def test_007_update_ticket_client_success(self):
        payload = {
            "codigo": "2",
            "titulo": "Google Update",
            "severidad": "S4",
            "prioridad": "BAJA",
            "estado": "PENDIENTE",
            "description": "... Doesn't work...",
            "fechaLimite": "2023-06-28T03:00:00.000+00:00",
            "fechaCreacion": "2023-06-20T21:15:51.375+00:00",
            "cliente": 5,
            "versionProducto": 3
        }

        id = "2"
        response = requests.put(f'{self.base_url}/tickets/{id}?id={id}', json=payload)
        self.assertEqual(response.status_code, 200)  # Assuming the successful status code is 200
        self.assertEqual(response.json(), payload)
    
    def test_008_update_ticket_product_version_success(self):
        payload = {
            "codigo": "2",
            "titulo": "Google Update",
            "severidad": "S4",
            "prioridad": "BAJA",
            "estado": "PENDIENTE",
            "description": "... Doesn't work...",
            "fechaLimite": "2023-06-28T03:00:00.000+00:00",
            "fechaCreacion": "2023-06-20T21:15:51.375+00:00",
            "cliente": 5,
            "versionProducto": 10
        }

        id = "2"
        response = requests.put(f'{self.base_url}/tickets/{id}?id={id}', json=payload)
        self.assertEqual(response.status_code, 200)  # Assuming the successful status code is 200
        self.assertEqual(response.json(), payload)
   
    
    def test_010_update_ticket_description_success(self):
        payload = {
            "codigo": "2",
            "titulo": "Google Update",
            "severidad": "S4",
            "prioridad": "BAJA",
            "estado": "PENDIENTE",
            "description": "... Doesn't work...",
            "fechaLimite": "2023-06-28T03:00:00.000+00:00",
            "fechaCreacion": "2023-06-20T21:15:51.375+00:00",
            "cliente": 16,
            "versionProducto": 3
        }

        id = "2"
        response = requests.put(f'{self.base_url}/tickets/{id}?id={id}', json=payload)
        self.assertEqual(response.status_code, 200)  # Assuming the successful status code is 200
        self.assertEqual(response.json(), payload)

    def test_011_update_ticket_client_success(self):
        payload = {
            "codigo": "2",
            "titulo": "Google Update",
            "severidad": "S4",
            "prioridad": "BAJA",
            "estado": "PENDIENTE",
            "description": "... Doesn't work...",
            "fechaLimite": "2023-06-28T03:00:00.000+00:00",
            "fechaCreacion": "2023-06-20T21:15:51.375+00:00",
            "cliente": 5,
            "versionProducto": 3
        }

        id = "2"
        response = requests.put(f'{self.base_url}/tickets/{id}?id={id}', json=payload)
        self.assertEqual(response.status_code, 200)  # Assuming the successful status code is 200
        self.assertEqual(response.json(), payload)
    
    def test_012_update_ticket_product_version_success(self):
        payload = {
            "codigo": "2",
            "titulo": "Google Update",
            "severidad": "S4",
            "prioridad": "BAJA",
            "estado": "PENDIENTE",
            "description": "... Doesn't work...",
            "fechaLimite": "2023-06-28T03:00:00.000+00:00",
            "fechaCreacion": "2023-06-20T21:15:51.375+00:00",
            "cliente": 5,
            "versionProducto": 10
        }

        id = "2"
        response = requests.put(f'{self.base_url}/tickets/{id}?id={id}', json=payload)
        self.assertEqual(response.status_code, 200)  # Assuming the successful status code is 200
        self.assertEqual(response.json(), payload)
    
    def test_013_update_ticket_state_success(self):
        payload = {
            "codigo": "2",
            "titulo": "Google Update",
            "severidad": "S4",
            "prioridad": "BAJA",
            "estado": "RESUELTO",
            "description": "... Doesn't work...",
            "fechaLimite": "2023-06-28T03:00:00.000+00:00",
            "fechaCreacion": "2023-06-20T21:15:51.375+00:00",
            "cliente": 5,
            "versionProducto": 10
        }

        id = "2"
        response = requests.put(f'{self.base_url}/tickets/{id}?id={id}', json=payload)
        self.assertEqual(response.status_code, 200)  # Assuming the successful status code is 200
        self.assertEqual(response.json(), payload)
    

    def test_014_update_ticket_fail(self):
        payload = {
            "codigo": "2",
            "titulo": "Google",
            "severidad": "S4",
            "prioridad": "ALTA",
            "estado": "RESUELTO",
            "description": "string",
            "fechaLimite": "2023-06-20T21:15:51.375+00:00",
            "fechaCreacion": "2023-06-20T21:15:51.375+00:00",
            "cliente": 16,
            "versionProducto": 3
        }
        id = "CodigoInvalido"
        response = requests.put(f'{self.base_url}/tickets/{id}?id={id}', json=payload)
        self.assertEqual(response.status_code, 404)  # Assuming the successful status code is 200
        self.assertEqual(response.json(), {"message": ["Ticket not found"]})

    
    def test_015_cant_update_closed_ticket(self): 
        # Given a ticket id
        payload = {
            "codigo": "2",
            "titulo": "Google",
            "severidad": "S1",
            "prioridad": "ALTA",
            "estado": "RESUELTO",
            "description": "string",
            "fechaLimite": "2023-06-20T21:15:51.375+00:00",
            "fechaCreacion": "2023-06-20T21:15:51.375+00:00",
            "cliente": 16,
            "versionProducto": 3
        }

        codigo = "2"
        # When trying to get the ticket info
        response = requests.put(f'{self.base_url}/tickets/{codigo}?id={codigo}', json=payload)
        # Then ticket info is returned
        self.assertEqual(response.status_code, 404)
        self.assertEqual(response.json(), {"message": ["Closed tickets can't be updated"]})


if __name__ == '__main__':
    unittest.main()
