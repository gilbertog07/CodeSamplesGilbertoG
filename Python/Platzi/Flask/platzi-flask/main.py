from flask import Flask, request, make_response, redirect, render_template, session, url_for
from flask_bootstrap import Bootstrap
from flask_wtf import FlaskForm
from wtforms.fields import StringField, PasswordField, SubmitField
from wtforms.validators import DataRequired


app = Flask(__name__)

app.config['SECRET_KEY'] = 'SUPER SECRETO'

bootstrap = Bootstrap(app)

todos = ['Comprar cafe', 'Enviar solicitud de compra', 'Entregar video a productor']


class LoginForm(FlaskForm):
    username = StringField('Nombre de Usuario: ', validators=[DataRequired()])
    password = PasswordField('Contraseña: ', validators=[DataRequired()])
    submit = SubmitField('Enviar')


@app.errorhandler(404)
def not_found(error):
    return render_template('404.html', error=error)


@app.errorhandler(500)
def server_error(error):
    return render_template('500.html')


@app.route('/')
def index():
    #raise(Exception('500 error')) #Para probar error 500
    user_ip = request.remote_addr

    response = make_response(redirect('/hello'))
    #response.set_cookie('user_ip', user_ip)
    session['user_ip'] = user_ip

    return response


@app.route('/hello', methods=['GET','POST'])
def hello():
    #user_ip = request.cookies.get('user_ip') # Obtener el IP de una Cookie
    user_ip = session.get('user_ip') # Obtener el IP de la sesion actual
    login_form = LoginForm()
    username = session.get('username')
    context = {
        'user_ip': user_ip,
        'todos': todos,
        'login_form': login_form,
        'username': username}

    if request.method == 'POST' and login_form.validate():
    #if login_form.validate_on_submit():
        username = login_form.username.data
        session['username'] = username

        return redirect(url_for('index'))

    #return 'Hello World Platzi, tu ip es {}'.format(user_ip)
    #return render_template('hello.html', user_ip=user_ip, todos=todos) # llamado a un template en HTML
    return render_template('hello.html', **context) # llamado a un template en HTML (Pasa toda las variables de un diccionarios al HTML)
