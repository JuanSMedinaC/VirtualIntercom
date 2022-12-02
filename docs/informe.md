# Informe Proyecto Final

## Introducción
Mediante este proyecto se desarrolló una aplicación de citófono virtual para un edificio de dos apartamentos. 

## Objetivo genereal
Vincular lo aprendido a lo largo de curso con la parte de programación, de esta manera poder crear una aplicación cliente – servidor.

## Dificultades encontradas 
- Conectar los dos apartamentos en simultaneo y al mismo tiempo dichos apartamentos conectarlos con la recepción del edificio. **Solución**:  Interpretamos la aplicación como un chat, sin embargo, diferenciamos los tipos de mensaje mediante la separación del string con (;;). De esta manera sabemos cuándo hay una conversación entres los apartamentos y cuando hay una persona en la recepción.
- El uso de hilos para la conección simultanea de las clases. **Solución**: ver vídeso en YouTube.
- Decidir si se usa TCP o UDP. **Solución**: elegimos la conexión TCP, ya que en este hay más confiabilidad en la conexión y no hay peridad de datos.

## Conclusión 
La estrategia de que tanto los apartamentos y la recepción son clientes y servidores nos facilitó la comunicación entre ellos. Así no era necesario la esperar de una respuesta para poder enviar otro mensaje.