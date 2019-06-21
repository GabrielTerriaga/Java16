package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Post {

	//Declarei uma constante por causa do formato da data
	//Assim nao preciso ficar instanciando o SimpleDateFormat
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	
	private Date moment;
	private String title;
	private String content;
	private Integer likes;
	
	//Associação
	private List<Comment> comments = new ArrayList<>();
	
	//Construtores
	public Post() {
	}

	//Não pode colocar lista por que precisa ser estanciada por padrão na classe
	public Post(Date moment, String title, String content, Integer likes) {
		this.moment = moment;
		this.title = title;
		this.content = content;
		this.likes = likes;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getLikes() {
		return likes;
	}

	public void setLikes(Integer likes) {
		this.likes = likes;
	}

	public List<Comment> getComment() {
		return comments;
	}

	/*Precisa remover esse set para que não seja setado uma lista dentro da outra (substituir) !CUIDADO!
	public void setComment(List<Comment> comment) {
		this.comment = comment;
	}*/
	
	//Metodos
	public void addComment(Comment comment) {
		comments.add(comment);
	}
	
	public void removeComment(Comment comment) {
		comments.remove(comment);
	}
	
	/*Usuando StringBuilder, nesse caso pode haver muitos comentarios e se utilizar apenas o
	toString vai ficar muito pesado na memória (String muito grande composto por outros String pequenos)
	*/	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(title + "\n");
		sb.append(likes);
		sb.append(" Likes - ");
		sb.append(sdf.format(moment) + "\n");
		sb.append(content + "\n");
		sb.append("Comments: \n");
		//Precisa criar um ForEach para percorrer arrayList dos comentarios
		for (Comment c : comments) {
			//get para pegar comentarios dentro do meu list
			sb.append(c.getText() + "\n");
		}
		//retornar o StringBuilder convertido em String
		return sb.toString();
	}
}
