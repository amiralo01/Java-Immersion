# Java-Immersion: Alura Stickers <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original.svg" width="40" height="40" /> 

Este é o projeto da Imersão Java realizada pela [Alura](https://www.alura.com.br/) onde se aprendeu a trabalhar com APIs, utilizando a linguagem JAVA.

O mesmo consiste na criação de um gerador de figurinhas/imagens utilizando uma [API](https://aws.amazon.com/pt/what-is/api/) e inserindo uma legenda e uma imagem da escolha do programador.

O projeto foi moldado para facilitar o acréscimo de novas APIs para a geração de novas imagens de diferentes fontes. As APIs utilizadas neste projeto foram fornecidas pelo [IMDB](https://developer.imdb.com/documentation/api-documentation/getting-access/?ref_=side_nav) e pela [NASA](https://api.nasa.gov/).

## Exemplo de uma das imagens que foram geradas:

<div align="center">
<img src = "https://user-images.githubusercontent.com/102382923/230645589-58afb99c-478d-4981-9b23-38aa97c15e81.png" width = "500"/>
</div>

## Tópicos de aprendizado e desafios:

Além da funcionalidade básica mencionada anteriormente, também foi proposto alguns desafios para uma melhor dinâmica de aprendizado. A seguir alguns dos principais tópicos de desafios que foram propostos.

*  Criação do diretório de saída das imagens, se ainda não existir.
*  Centralização do texto no sticker.
*  Configurar uma fonte para o texto (para seguir a premissa de um meme foi utilizado a fonte impact).
*  Aplicar contorno (outline) no texto da imagem.
*  Transformar a classe que representa os conteúdos em um [Record](https://www.guiadojava.com.br/2021/04/java-records.html), disponível a partir do Java 16.
*  Criar [exceções](https://github.com/amiralo01/Java-Immersion/blob/main/Alura_Stickers/src/ClientHttpException.java) personalizadas e usá-las na classe que implementa o [cliente HTTP](https://github.com/amiralo01/Java-Immersion/blob/main/Alura_Stickers/src/ClientHttp.java).

## Referências

* [Estilização do texto no terminal](https://www.alura.com.br/artigos/decorando-terminal-cores-emojis)
* [Documentação do Java](https://dev.java/learn/)
* [Documentação da API do IMDB](https://developer.imdb.com/documentation)
* [Documentação da API da NASA](https://api.nasa.gov/)
* [Imersão Java da Alura](https://www.alura.com.br/imersao-java)
