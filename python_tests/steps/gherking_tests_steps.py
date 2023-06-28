import requests
from behave import given, when, then
from behave import fixture, use_fixture

@given('Product, version, and client')
def step_given_product_version_and_client(context):
    context.base_url = 'https://tp-memo1-tribu-a-soporte.onrender.com'
    context.payload = {
        "codigo": "16",
        "titulo": "Problema inscripción curso de verano",
        "severidad": "S1",
        "prioridad": "ALTA",
        "estado": "PENDIENTE",
        "description": "Cuando el alumno se quiere inscribir a un curso de verano no le aparecen todas las materias",
        "fechaLimite": "2023-06-28T03:00:00.000+00:00",
        "fechaCreacion": "2023-06-20T21:15:51.375+00:00",
        "cliente": 1,
        "versionProducto": 1
    }

@given('Product and version')
def step_given_product_and_version(context):
    context.base_url = 'https://tp-memo1-tribu-a-soporte.onrender.com'
    context.payload = {
        "codigo": "16",
        "titulo": "Problema inscripción curso de verano",
        "severidad": "S1",
        "prioridad": "ALTA",
        "estado": "PENDIENTE",
        "description": "Cuando el alumno se quiere inscribir a un curso de verano no le aparecen todas las materias",
        "fechaLimite": "2023-06-28T03:00:00.000+00:00",
        "fechaCreacion": "2023-06-20T21:15:51.375+00:00",
        "versionProducto": 1
    }

@given('Product and client')
def step_given_product_and_client(context):
    context.base_url = 'https://tp-memo1-tribu-a-soporte.onrender.com'
    context.payload = {
        "codigo": "16",
        "titulo": "Problema inscripción curso de verano",
        "severidad": "S1",
        "prioridad": "ALTA",
        "estado": "PENDIENTE",
        "description": "Cuando el alumno se quiere inscribir a un curso de verano no le aparecen todas las materias",
        "fechaLimite": "2023-06-28T03:00:00.000+00:00",
        "fechaCreacion": "2023-06-20T21:15:51.375+00:00",
        "cliente": 1,
    }

@given('Client and version')
def step_given_client_and_version(context):
    context.base_url = 'https://tp-memo1-tribu-a-soporte.onrender.com'
    context.payload = {
        "codigo": "16",
        "severidad": "S1",
        "prioridad": "ALTA",
        "estado": "PENDIENTE",
        "description": "Cuando el alumno se quiere inscribir a un curso de verano no le aparecen todas las materias",
        "fechaLimite": "2023-06-28T03:00:00.000+00:00",
        "fechaCreacion": "2023-06-20T21:15:51.375+00:00",
        "cliente": 1,
        "versionProducto": 1
    }

@when('Trying to create the ticket')
def step_when_creating_the_ticket(context):
    context.base_url = 'https://tp-memo1-tribu-a-soporte.onrender.com'
    response = requests.post(f'{context.base_url}/tickets', json=context.payload)
    link = f'{context.base_url}/tickets'
    print(link)
    context.response = response

@then('Ticket is created')
def step_then_ticket_is_created(context):
    context.base_url = 'https://tp-memo1-tribu-a-soporte.onrender.com'
    response = context.response
    assert response.status_code == 201
    context.payload = {
        "codigo": "16",
        "titulo": "Problema inscripción curso de verano",
        "severidad": "S1",
        "prioridad": "ALTA",
        "estado": "PENDIENTE",
        "description": "Cuando el alumno se quiere inscribir a un curso de verano no le aparecen todas las materias",
        "fechaLimite": "2023-06-28T03:00:00.000+00:00",
        "fechaCreacion": "2023-06-20T21:15:51.375+00:00",
        "cliente": 1,
        "versionProducto": 1
    }

@then('Ticket is not created')
def step_then_ticket_is_not_created(context):
    context.base_url = 'https://tp-memo1-tribu-a-soporte.onrender.com'
    response = context.response
    assert response.status_code == 400

@then('Client is requested')
def step_then_client_is_requested(context):
    context.base_url = 'https://tp-memo1-tribu-a-soporte.onrender.com'
    response = context.response
    assert response.json() == {
        "message": ["Client is required"]
    }

@then('Version is requested')
def step_then_version_is_requested(context):
    context.base_url = 'https://tp-memo1-tribu-a-soporte.onrender.com'
    response = context.response
    assert response.json() == {
        "message": ["Version is required"]
    }

@then('Product is requested')
def step_then_product_is_requested(context):
    context.base_url = 'https://tp-memo1-tribu-a-soporte.onrender.com'
    response = context.response
    assert response.json() == {
        "message": ["Title is required"]
    }

@given('Ticket with state PENDIENTE or EMPEZADO')
def step_given_ticket_with_state_pendiente_or_empezando(context):
    context.base_url = 'https://tp-memo1-tribu-a-soporte.onrender.com'
    context.ticket_id = "16"  # Replace with the valid ticket ID


@when('Updating the ticket severity')
def step_when_updating_ticket_severity(context):
    context.base_url = 'https://tp-memo1-tribu-a-soporte.onrender.com'
    context.new_severity = "S2"  # Replace with the desired severity value
    payload = {
        "codigo": "16",
        "titulo": "Problema inscripción curso de verano",
        "severidad": context.new_severity,
        "prioridad": "ALTA",
        "estado": "PENDIENTE",
        "description": "Cuando el alumno se quiere inscribir a un curso de verano no le aparecen todas las materias",
        "fechaLimite": "2023-06-28T03:00:00.000+00:00",
        "fechaCreacion": "2023-06-20T21:15:51.375+00:00",
        "cliente": 1,
        "versionProducto": 1
    }
    response = requests.put(f'{context.base_url}/tickets/{context.ticket_id}?codigo={context.ticket_id}', json=payload)
    context.response = response


@then('Ticket severity should be updated successfully')
def step_then_ticket_severity_updated_successfully(context):
    context.base_url = 'https://tp-memo1-tribu-a-soporte.onrender.com'
    response = context.response
    print(response.text)
    assert response.status_code == 200
    assert response.json().get('severidad') == context.new_severity


@when('Updating the ticket priority')
def step_when_updating_ticket_priority(context):
    context.base_url = 'https://tp-memo1-tribu-a-soporte.onrender.com'
    context.new_priority = 'MEDIA'  # Replace with the desired priority value
    payload = {
        "codigo": "16",
        "titulo": "Problema inscripción curso de verano",
        "severidad": "S1",
        "prioridad": context.new_priority,
        "estado": "PENDIENTE",
        "description": "Cuando el alumno se quiere inscribir a un curso de verano no le aparecen todas las materias",
        "fechaLimite": "2023-06-28T03:00:00.000+00:00",
        "fechaCreacion": "2023-06-20T21:15:51.375+00:00",
        "cliente": 1,
        "versionProducto": 1
    }
    response = requests.put(f'{context.base_url}/tickets/{context.ticket_id}?codigo={context.ticket_id}', json=payload)
    context.response = response


@then('Ticket priority should be updated successfully')
def step_then_ticket_priority_updated_successfully(context):
    context.base_url = 'https://tp-memo1-tribu-a-soporte.onrender.com'
    response = context.response
    assert response.status_code == 200
    assert response.json().get('prioridad') == context.new_priority


@when('Updating the ticket title')
def step_when_ticket_title_updated_successfully(context):
    context.base_url = 'https://tp-memo1-tribu-a-soporte.onrender.com'
    context.new_title = "Problema con la inscripción curso de verano" # Replace with the desired title value
    print(context.new_title)
    payload = {
        "codigo": "16",
        "titulo": context.new_title,
        "severidad": "S1",
        "prioridad": "ALTA",
        "estado": "PENDIENTE",
        "description": "Cuando el alumno se quiere inscribir a un curso de verano no le aparecen todas las materias",
        "fechaLimite": "2023-06-28T03:00:00.000+00:00",
        "fechaCreacion": "2023-06-20T21:15:51.375+00:00",
        "cliente": 1,
        "versionProducto": 1
    }
    response = requests.put(f'{context.base_url}/tickets/{context.ticket_id}?codigo={context.ticket_id}', json=payload)
    print(response.text)
    context.response = response

@then('Ticket title should be updated successfully')
def step_then_ticket_title_updated_successfully(context):
    context.base_url = 'https://tp-memo1-tribu-a-soporte.onrender.com'
    response = context.response
    assert response.status_code == 200
    assert response.json().get('titulo') == context.new_title

@when('Updating the ticket description')
def step_when_ticket_description_updated_successfully(context):
    context.base_url = 'https://tp-memo1-tribu-a-soporte.onrender.com'
    context.new_description = "Cuando el alumno se quiere inscribir a un curso de verano no le aparecen todas las materias, por ende no se pueden inscribir."  # Replace with the desired description value
    payload = {
        "codigo": "16",
        "titulo": "Problema inscripción curso de verano",
        "severidad": "S1",
        "prioridad": "ALTA",
        "estado": "PENDIENTE",
        "description": context.new_description,
        "fechaLimite": "2023-06-28T03:00:00.000+00:00",
        "fechaCreacion": "2023-06-20T21:15:51.375+00:00",
        "cliente": 1,
        "versionProducto": 1
    }
    response = requests.put(f'{context.base_url}/tickets/{context.ticket_id}?codigo={context.ticket_id}', json=payload)
    context.response = response

@then('Ticket description should be updated successfully')
def step_then_ticket_description_updated_successfully(context):
    context.base_url = 'https://tp-memo1-tribu-a-soporte.onrender.com'
    response = context.response
    assert response.status_code == 200
    assert response.json().get('description') == context.new_description

@when('Updating the ticket client')
def step_when_ticket_client_updated_successfully(context):
    context.base_url = 'https://tp-memo1-tribu-a-soporte.onrender.com'
    context.new_client = 17
    payload = {
        "codigo": "16",
        "titulo": "Problema inscripción curso de verano",
        "severidad": "S1",
        "prioridad": "ALTA",
        "estado": "PENDIENTE",
        "description": "Cuando el alumno se quiere inscribir a un curso de verano no le aparecen todas las materias",
        "fechaLimite": "2023-06-28T03:00:00.000+00:00",
        "fechaCreacion": "2023-06-20T21:15:51.375+00:00",
        "cliente": context.new_client,
        "versionProducto": 1
    }
    response = requests.put(f'{context.base_url}/tickets/{context.ticket_id}?codigo={context.ticket_id}', json=payload)
    context.response = response

@then('Ticket client should be updated successfully')
def step_then_ticket_client_updated_successfully(context):
    context.base_url = 'https://tp-memo1-tribu-a-soporte.onrender.com'
    response = context.response
    assert response.status_code == 200
    assert response.json().get('cliente') == context.new_client

@when('Updating the ticket product version')
def step_when_ticket_version_updated_successfully(context):
    context.base_url = 'https://tp-memo1-tribu-a-soporte.onrender.com'
    context.new_version = 0
    payload = {
        "codigo": "16",
        "titulo": "Problema inscripción curso de verano",
        "severidad": "S1",
        "prioridad": "ALTA",
        "estado": "PENDIENTE",
        "description": "Cuando el alumno se quiere inscribir a un curso de verano no le aparecen todas las materias",
        "fechaLimite": "2023-06-28T03:00:00.000+00:00",
        "fechaCreacion": "2023-06-20T21:15:51.375+00:00",
        "cliente": 1,
        "versionProducto": context.new_version
    }
    response = requests.put(f'{context.base_url}/tickets/{context.ticket_id}?codigo={context.ticket_id}', json=payload)
    context.response = response

@then('Ticket product version should be updated successfully')
def step_then_ticket_version_updated_successfully(context):
    context.base_url = 'https://tp-memo1-tribu-a-soporte.onrender.com'
    response = context.response
    assert response.status_code == 200
    assert response.json().get('versionProducto') == context.new_version

@when('Updating the ticket state')
def step_when_ticket_state_updated_successfully(context):
    context.base_url = 'https://tp-memo1-tribu-a-soporte.onrender.com'
    context.new_state = 'EMPEZADO'
    payload = {
        "codigo": "16",
        "titulo": "Problema inscripción curso de verano",
        "severidad": "S1",
        "prioridad": "ALTA",
        "estado": context.new_state,
        "description": "Cuando el alumno se quiere inscribir a un curso de verano no le aparecen todas las materias",
        "fechaLimite": "2023-06-28T03:00:00.000+00:00",
        "fechaCreacion": "2023-06-20T21:15:51.375+00:00",
        "cliente": 1,
        "versionProducto": 1
    }
    response = requests.put(f'{context.base_url}/tickets/{context.ticket_id}?codigo={context.ticket_id}', json=payload)
    context.response = response

@then('Ticket state should be updated successfully')
def step_then_ticket_state_updated_successfully(context):
    context.base_url = 'https://tp-memo1-tribu-a-soporte.onrender.com'
    response = context.response
    assert response.status_code == 200
    assert response.json().get('estado') == context.new_state

@given('Invalid ticket id')
def step_when_given_invalid_ticket_id(context):
    context.base_url = 'https://tp-memo1-tribu-a-soporte.onrender.com'
    context.ticket_id = 'InvalidId'


@then('Ticket should fail with a "Ticket not found" error')
def step_then_ticket_should_fail_with_ticket_not_found_error(context):
    context.base_url = 'https://tp-memo1-tribu-a-soporte.onrender.com'
    response = context.response
    assert response.status_code == 404
    assert response.json() == {
        "message": ["Ticket not found"]
    }

@given('Ticket with state RESUELTO')
def step_given_ticket_with_state_resuelto(context):
    context.base_url = 'https://tp-memo1-tribu-a-soporte.onrender.com'
    context.ticket_id = '16'
    context.new_state = 'RESUELTO'
    payload = {
        "codigo": "16",
        "titulo": "Problema inscripción curso de verano",
        "severidad": "S1",
        "prioridad": "ALTA",
        "estado": context.new_state,
        "description": "Cuando el alumno se quiere inscribir a un curso de verano no le aparecen todas las materias",
        "fechaLimite": "2023-06-28T03:00:00.000+00:00",
        "fechaCreacion": "2023-06-20T21:15:51.375+00:00",
        "cliente": 1,
        "versionProducto": 1
    }
    requests.put(f'{context.base_url}/tickets/{context.ticket_id}?codigo={context.ticket_id}', json=payload)
    
@then(u'Update should fail with a "Closed tickets cant be updated" message')
def step_then_ticket_should_fail_with_ticket_is_already_resolved_error(context):
    context.base_url = 'https://tp-memo1-tribu-a-soporte.onrender.com'
    response = context.response
    print(response.text)
    assert response.status_code == 404
    assert response.json() == {
        "message": ["Closed tickets can't be updated"]
    }
    #requests.delete(f'{context.base_url}/tickets/{context.ticket_id}?codigo={context.ticket_id}')  


@when ('Delete the ticket')
def step_when_deleting_the_ticket(context):
    context.base_url = 'https://tp-memo1-tribu-a-soporte.onrender.com'
    response = requests.delete(f'{context.base_url}/tickets/{context.ticket_id}?codigo={context.ticket_id}')
    context.response = response

@then('Ticket is deleted')
def step_then_ticket_is_deleted(context):
    context.base_url = 'https://tp-memo1-tribu-a-soporte.onrender.com'
    response = context.response
    print(response.text)
    assert response.status_code == 200

@then('Ticket is not deleted')
def step_when_deleting_a_ticket_with_invalid_id(context):
    context.base_url = 'https://tp-memo1-tribu-a-soporte.onrender.com'
    response = requests.delete(f'{context.base_url}/tickets/{context.ticket_id}?codigo={context.ticket_id}')
    context.response = response
    print(response.text)
    assert response.status_code == 200

@given('Ticket valid id')
def step_given_ticket_valid_id(context):
    context.base_url = 'https://tp-memo1-tribu-a-soporte.onrender.com'
    context.ticket_id = '16'

@given('Ticket invalid id')
def step_given_ticket_invalid_id(context):  
    context.base_url = 'https://tp-memo1-tribu-a-soporte.onrender.com'
    context.ticket_id = 'InvalidId'

@when('Getting ticket information by ticket ID')
def step_when_getting_ticket_information(context):
    context.base_url = 'https://tp-memo1-tribu-a-soporte.onrender.com'
    response = requests.get(f'{context.base_url}/tickets/{context.ticket_id}?codigo={context.ticket_id}')
    context.response = response

@given('Ticket valid client ID')
def step_given_ticket_valid_client_id(context):
    context.base_url = 'https://tp-memo1-tribu-a-soporte.onrender.com'
    context.client_id = 1

@given('Ticket invalid client ID')
def step_given_ticket_invalid_client_id(context):
    context.base_url = 'https://tp-memo1-tribu-a-soporte.onrender.com'
    context.client_id = 55

@when('Getting ticket information by client ID')
def step_when_getting_ticket_information_by_client_id(context):
    context.base_url = 'https://tp-memo1-tribu-a-soporte.onrender.com'
    response = requests.get(f'{context.base_url}/clientes/{context.client_id}/tickets')
    context.response = response

@then('Ticket information is returned')
def step_then_ticket_information_is_returned(context):
    context.base_url = 'https://tp-memo1-tribu-a-soporte.onrender.com'
    response = context.response
    assert response.status_code == 200

@then('Ticket information is not returned')
def step_then_ticket_information_is_not_returned(context):
    context.base_url = 'https://tp-memo1-tribu-a-soporte.onrender.com'
    response = context.response
    print(response.text)
    assert response.status_code == 404
 
# Esto deberia eliminar el ticket creado durante el test, pero no funciona, así que lo hago en el último test
#def after_all(context):
#    context.base_url = 'https://tp-memo1-tribu-a-soporte.onrender.com'
#    requests.delete(f'{context.base_url}/tickets/{context.ticket_id}?codigo={context.ticket_id}')    
