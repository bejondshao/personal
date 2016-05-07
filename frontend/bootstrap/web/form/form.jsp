<%--
  Created by IntelliJ IDEA.
  User: bejond
  Date: 5/5/16
  Time: 6:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Bootstrap - typesetting</title>
    <!-- 包含头部信息用于适应不同设备 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 包含bootstrap样式表 -->
    <link rel="stylesheet" href="../bootstrap3/css/bootstrap.min.css">
    <link rel="stylesheet" href="../bootstrap3/css/bootstrap-theme.min.css">
    <style type="text/css">
        .a {
            border: 2px solid red;
            background-color: lightcyan;
        }

        .b {
            border: 2px solid blue;
            background-color: lightcoral;
        }

        .c {
            border: 2px solid black;
            background-color: lightgoldenrodyellow;
        }

        .d {
            border: 1px solid cornflowerblue;
            background-color: lightpink;
        }
    </style>
</head>
<body>
基本实例<br/>
<form>
    <div>
        <label>Email address</label>
        <input type="email" class="form-control" id="email1" placeholder="Email">
    </div>
    <div class="form-group">
        <label for="password1">Password</label>
        <input type="password" id="password1" placeholder="Password">
    </div>
    <div class="form-group">
        <label for="inputFile">File input</label>
        <input type="file" id="inputFile">
        <p class="help-block">Example block-level help text here.</p>
    </div>
    <div class="checkbox">
        <label>
            <input type="checkbox"> Check me out
        </label>
    </div>
    <button type="submit" class="btn btn-default">Submit</button>
</form>
<hr/>
内联表单<br/>
<form class="form-inline">
    <div class="form-group">
        <label for="name2">Name</label>
        <input type="text" class="form-control" id="name2" placeholder="Bejond Shao">
    </div>
    <div class="form-group">
        <label for="password2">Password</label>
        <input type="password" class="form-control" id="password2" placeholder="Password">
    </div>
    <button type="submit" class="btn btn-default">Send invitation</button>
</form>
<form class="form-inline">
    <div class="form-group">
        <label class="sr-only" for="exampleInputEmail3">Email address</label>
        <input type="email" class="form-control" id="exampleInputEmail3" placeholder="Email">
    </div>
    <div class="form-group">
        <label class="sr-only" for="exampleInputPassword3">Password</label>
        <input type="password" class="form-control" id="exampleInputPassword3" placeholder="Password">
    </div>
    <div class="checkbox">
        <label>
            <input type="checkbox"> Remember me
        </label>
    </div>
    <button type="submit" class="btn btn-default">Sign in</button>
</form>
<form class="form-inline">
    <div class="form-group">
        <label class="sr-only" for="exampleInputAmount">Amount (in dollars)</label>
        <div class="input-group">
            <div class="input-group-addon">$</div>
            <input type="text" class="form-control" id="exampleInputAmount" placeholder="Amount">
            <div class="input-group-addon">.00</div>
        </div>
    </div>
    <button type="submit" class="btn btn-primary">Transfer cash</button>
</form>
<hr/>
水平排列的表单<br/>
<form class="form-horizontal">
    <div class="form-group">
        <label for="inputEmail3" class="col-sm-2">Email</label>
        <div class="col-sm-10">
            <input type="email" class="form-control" id="inputEmail3" placeholder="Email">
        </div>
    </div>
    <div class="form-group">
        <label for="inputPassword3" class="col-sm-2 control-label">Password</label>
        <div class="col-sm-10">
            <input type="password" class="form-control" id="inputPassword3" placeholder="Password">
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <div class="checkbox">
                <label>
                    <input type="checkbox"> Remember me
                </label>
            </div>
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-default">Sign in</button>
        </div>
    </div>
</form>
<hr/>
输入框

<p>包括大部分表单控件、文本输入域控件，还支持所有 HTML5 类型的输入控件： text、password、datetime、datetime-local、date、month、time、week、number、email、url、search、tel 和 color。</p>
<input type="text" class="form-control" placeholder="Text input">
<textarea class="form-control" rows="3" placeholder="Input text here"></textarea>
<hr/>
<div class="checkbox">
    <label>
        <input type="checkbox" value="">
        Option one is this and that&mdash;be sure to include why it's great
    </label>
</div>
<div class="checkbox disabled">
    <label>
        <input type="checkbox" value="" disabled>
        Option two is disabled
    </label>
</div>
<hr/>
<div class="radio">
    <label>
        <input type="radio" name="optionsRadios" id="optionsRadios1" value="option1" checked>
        Option one is this and that&mdash;be sure to include why it's great
    </label>
</div>
<div class="">
    <label>
        <input type="radio" name="optionsRadios" id="optionsRadios2" value="option2">
        Option two can be something else and selecting it will deselect option one
    </label>
</div>
<div class="radio disabled">
    <label>
        <input type="radio" name="optionsRadios" id="optionsRadios3" value="option3" disabled>
        Option three is disabled
    </label>
</div>
<hr/>
<label class="checkbox-inline">
    <input type="checkbox" id="inlineCheckbox1" value="option1"> 1
</label>
<label class="checkbox-inline">
    <input type="checkbox" id="inlineCheckbox2" value="option2"> 2
</label>
<label class="checkbox-inline">
    <input type="checkbox" id="inlineCheckbox3" value="option3"> 3
</label>

<label class="radio-inline">
    <input type="radio" name="inlineRadioOptions" id="inlineRadio1" value="option1"> 1
</label>
<label class="radio-inline">
    <input type="radio" name="inlineRadioOptions" id="inlineRadio2" value="option2"> 2
</label>
<label class="radio-inline">
    <input type="radio" name="inlineRadioOptions" id="inlineRadio3" value="option3"> 3
</label>
<hr/>
不带label文本的checkbox和radio<br/>
<div class="checkbox">
    <label>
        <input type="checkbox" id="blankCheckbox" value="option1" aria-label="...">
    </label>
</div>
<div class="radio">
    <label>
        <input type="radio" name="blankRadio" id="blankRadio1" value="option1" aria-label="...">
    </label>
</div>
<hr/>
下拉列表<br/>
<select class="form-control">
    <option>1</option>
    <option>2</option>
    <option>3</option>
    <option>4</option>
    <option>5</option>
</select>
<hr/>
<select multiple class="form-control">
    <option>1</option>
    <option>2</option>
    <option>3</option>
    <option>4</option>
    <option>5</option>
</select>
<hr/>
静态控件

如果需要在表单中将一行纯文本和 label 元素放置于同一行，为 &lt;p&gl; 元素添加 .form-control-static 类即可。
<br/>
<form class="form-horizontal">
    <div class="form-group">
        <label class="col-sm-2 control-label">Email</label>
        <div class="col-sm-10">
            <p class="form-control-static">email@example.com</p>
        </div>
    </div>
    <div class="form-group">
        <label for="inputPassword" class="col-sm-2 control-label">Password</label>
        <div class="col-sm-10">
            <input type="password" class="form-control" id="inputPassword" placeholder="Password">
        </div>
    </div>
</form>
<hr/>
禁用状态
<p>为输入框设置 disabled 属性可以禁止其与用户有任何交互（焦点、输入等）。被禁用的输入框颜色更浅，并且还添加了 not-allowed 鼠标状态。</p>
<input class="form-control" id="disabledInput" type="text" placeholder="Disabled input here" disabled>
<form>
<fieldset disabled>
    <div class="form-group">
        <label for="disabledTextInput">Disabled input</label>
        <input type="text" id="disabledTextInput" class="form-control" placeholder="Disabled input">
    </div>
    <div class="form-group">
        <label for="disabledSelect">Disabled select menu</label>
        <select id="disabledSelect" class="form-control">
            <option>Disabled select</option>
        </select>
    </div>
    <div class="checkbox">
        <label>
            <input type="checkbox"> Can't check this
        </label>
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</fieldset>
</form>
<hr/>
只读状态
<p>为输入框设置 readonly 属性可以禁止用户修改输入框中的内容。处于只读状态的输入框颜色更浅（就像被禁用的输入框一样），但是仍然保留标准的鼠标状态。</p>
<input class="form-control" type="text" placeholder="Readonly input here" readonly>
<hr/>
校验状态
<p>Bootstrap 对表单控件的校验状态，如 error、warning 和 success 状态，都定义了样式。使用时，添加 .has-warning、.has-error 或 .has-success 类到这些控件的父元素即可。任何包含在此元素之内的 .control-label、.form-control 和 .help-block 元素都将接受这些校验状态的样式。</p>
<div class="form-group has-success">
    <label class="control-label" for="inputSuccess1">Input with success</label>
    <input type="text" class="form-control" id="inputSuccess1">
</div>
<div class="form-group has-warning">
    <label class="control-label" for="inputWarning1">Input with warning</label>
    <input type="text" class="form-control" id="inputWarning1">
</div>
<div class="form-group has-error">
    <label class="control-label" for="inputError1">Input with error</label>
    <input type="text" class="form-control" id="inputError1">
</div>
<div class="has-success">
    <div class="checkbox">
        <label>
            <input type="checkbox" id="checkboxSuccess" value="option1">
            Checkbox with success
        </label>
    </div>
</div>
<div class="has-warning">
    <div class="checkbox">
        <label>
            <input type="checkbox" id="checkboxWarning" value="option1">
            Checkbox with warning
        </label>
    </div>
</div>
<div class="has-error">
    <div class="checkbox">
        <label>
            <input type="checkbox" id="checkboxError" value="option1">
            Checkbox with error
        </label>
    </div>
</div>
<hr/>
添加额外的图标
<p>你还可以针对校验状态为输入框添加额外的图标。只需设置相应的 .has-feedback 类并添加正确的图标即可。</p>
<div class="form-group has-success has-feedback">
    <label class="control-label" for="inputSuccess2">Input with success</label>
    <input type="text" id="inputSuccess2" class="form-control" aria-describedby="inputSuccess2Status">
    <span class="glyphicon glyphicon-ok form-control-feedback" aria-controls="true"></span>
    <span id="inputsuccess2Status" class="sr-only">(success)</span>
</div>
<div class="form-group has-warning has-feedback">
    <label class="control-label" for="inputWarning2">Input with warning</label>
    <input type="text" class="form-control" id="inputWarning2" aria-describedby="inputWarning2Status">
    <span class="glyphicon glyphicon-warning-sign form-control-feedback" aria-hidden="true"></span>
    <span id="inputWarning2Status" class="sr-only">(warning)</span>
</div>
<div class="form-group has-error has-feedback">
    <label class="control-label" for="inputError2">Input with error</label>
    <input type="text" class="form-control" id="inputError2" aria-describedby="inputError2Status">
    <span class="glyphicon glyphicon-remove form-control-feedback" aria-hidden="true"></span>
    <span id="inputError2Status" class="sr-only">(error)</span>
</div>
<div class="form-group has-success has-feedback">
    <label class="control-label" for="inputGroupSuccess1">Input group with success</label>
    <div class="input-group">
        <span class="input-group-addon">@</span>
        <input type="text" class="form-control" id="inputGroupSuccess1" aria-describedby="inputGroupSuccess1Status">
    </div>
    <span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true"></span>
    <span id="inputGroupSuccess1Status" class="sr-only">(success)</span>
</div>
<hr/>
控件尺寸
<p>通过 .input-lg 类似的类可以为控件设置高度，通过 .col-lg-* 类似的类可以为控件设置宽度。</p>
<input class="form-control input-lg" type="text" placeholder=".input-lg">
<input class="form-control" type="text" placeholder="Default input size">
<input class="form-control input-sm" type="text" placeholder=".input-sm">

<select class="form-control input-lg">.input-lg</select>
<select class="form-control">Default select size</select>
<select class="form-control input-sm">.input-sm</select>
<hr/>
水平排列的表单组的尺寸
<p>通过添加 .form-group-lg 或 .form-group-sm 类，为 .form-horizontal 包裹的 label 元素和表单控件快速设置尺寸。</p>
<form class="form-horizontal">
    <div class="form-group form-group-lg">
        <label class="col-sm-2 control-label" for="formGroupInputLarge">Large label</label>
        <div class="col-sm-10">
            <input class="form-control" type="text" id="formGroupInputLarge" placeholder="Large input">
        </div>
    </div>
    <div class="form-group form-group-sm">
        <label class="col-sm-2 control-label" for="formGroupInputSmall">Small label</label>
        <div class="col-sm-10">
            <input class="form-control" type="text" id="formGroupInputSmall" placeholder="Small input">
        </div>
    </div>
</form>
<hr/>
调整列尺寸
<p>用栅格系统中的列（column）包裹输入框或其任何父元素，都可很容易的为其设置宽度。</p>
<div class="row">
    <div class="col-xs-2">
        <input type="text" class="form-control" placeholder=".col-xs-2">
    </div>
    <div class="col-xs-3">
        <input type="text" class="form-control" placeholder=".col-xs-3">
    </div>
    <div class="col-xs-4">
        <input type="text" class="form-control" placeholder=".col-xs-4">
    </div>
</div>
<hr/>
附注文本
<p>针对表单控件的“块（block）”级辅助文本。</p>
<label class="sr-only" for="inputHelpBlock">Input with help text</label>
<input type="text" id="inputhelpblock" class="form-control" aria-describedby="helpBlock">
<span id="helpBlock" class="help-block">A block of help text that breaks onto a new line and may extend beyond one line.</span>
</body>
<!-- JavaScript 放置在文档最后面可以使页面加载速度更快 -->
<!-- 可选: 包含 jQuery 库 -->
<script src="../bootstrap3/js/jquery-2.2.3.min.js"></script>
<!-- 可选: 合并了 Bootstrap JavaScript 插件 -->
<script src="../bootstrap3/js/bootstrap.min.js"></script>
</html>
