# LoginSeguro
Projeto Spring Boot que usa Spring Security, BootStrap, Thymeleaf, Lombok e H2.

- [X] Spring Boot
- [X] Spring Security
- [X] Thymeleaf
- [X] BootStrap
- [X] Lombok
- [X] Controle de acesso com users in memory

Versão 2
- [ ] Controle de acesso via JPA

----------------------
Observações
----------------------
Os usuários estão definidos em memória nessa primeira versão e podem ser encontrados na classe de configuração: WebSecurityConfig.java
São eles (user/pass):
- admin/admin
- gestor/gestor

Na tela de login temos uma proteção do próprio Spring Security para ataques CRSF (Cross-Site Request Forgery).
Mais sobre o ataque CSRF: https://owasp.org/www-community/attacks/csrf
