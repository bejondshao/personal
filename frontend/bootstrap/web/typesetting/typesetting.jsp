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
<p class="">
    W3School 提供的内容仅用于培训。我们不保证内容的正确性。通过使用本站内容随之而来的风险与本站无关。W3School 简体中文版的所有内容仅供测试，对任何法律问题及风险不承担任何责任。当使用本站时，代表您已接受了本站的使用条款和隐私条款。版权所有，保留一切权利。 赞助商：上海赢科投资有限公司。 蒙ICP备06004630号
</p>
<p class="lead">
    W3School 提供的内容仅用于培训。我们不保证内容的正确性。通过使用本站内容随之而来的风险与本站无关。W3School 简体中文版的所有内容仅供测试，对任何法律问题及风险不承担任何责任。当使用本站时，代表您已接受了本站的使用条款和隐私条款。版权所有，保留一切权利。 赞助商：上海赢科投资有限公司。 蒙ICP备06004630号
</p>
<h1>h1. Bootstrap heading <small>Secondary text</small></h1>
<h2>h2. Bootstrap heading <small>Secondary text</small></h2>
<h3>h3. Bootstrap heading <small>Secondary text</small></h3>
<h4>h4. Bootstrap heading <small>Secondary text</small></h4>
<h5>h5. Bootstrap heading <small>Secondary text</small></h5>
<h6>h6. Bootstrap heading <small>Secondary text</small></h6>
高亮标签<mark>lighlight</mark><br/>
删除线<del>被删除的内容</del><br/>
无用文本<s>This line of text is meant to be treated as no longer accurate.</s><br/>
插入文本<ins>插入的内容</ins><br/>
下划线<u>This line of text will render as underlined</u><br/>
小号文本<small>小号文本</small><br/>
着重<strong>着重样式</strong><br/>
斜体<em>斜体样式</em><br/>
<hr/>
文本对齐: .text-left, .text-center, .text-right, .text-justify, .text-nowrap
<p class="text-left a">Left aligned text.</p>
<p class="text-center b">Center aligned text.</p>
<p class="text-right c">Right aligned text.</p>
<p class="text-justify d">Justified text. 在数学中，微分是对函数的局部变化率的一种线性描述。微分可以近似地描述当函数自变量的取值作足够小的改变时，函数的值是怎样改变的。当某些函数地描述当函数自变量的取值作足够小的改变时，函数的值是怎样改变的。当某些函数地描述当函数自变量的取值作足够小的改变时，函数的值是怎样改变的。当某些函数</p>
<p class="text-nowrap a">No wrap text. 在数学中，微分是对函数的局部变化率的一种线性描述。微分可以近似地描述当函数自变量的取值作足够小的改变时，函数的值是怎样改变的。当某些函数地描述当函数自变量的取值作足够小的改变时，函数的值是怎样改变的。当某些函数地描述当函数自变量的取值作足够小的改变时，函数的值是怎样改变的。当某些函数</p>
<hr/>
改变大小写...这难道不是js和后台的事么? 不过貌似css能做到可以统一界面风格
<p class="text-lowercase">Lowercased text.</p>
<p class="text-uppercase">Uppercased text.</p>
<p class="text-capitalize">Capitalized text.</p>
<hr/>
基本缩略语<abbr title="attribute description">attr</abbr><br/>
首字母缩略语<abbr title="HyperText Markup Language" class="initialism">HTML</abbr><br/>
<hr/>
地址
<address>
    <strong>Twitter, Inc.</strong><br>
    795 Folsom Ave, Suite 600<br>
    San Francisco, CA 94107<br>
    <abbr title="Phone">P:</abbr> (123) 456-7890
</address>

<address>
    <strong>Full Name</strong><br>
    <a href="mailto:#">first.last@example.com</a>
</address>
<hr/>
引用
默认样式的引用
<blockquote>
    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer posuere erat a ante.</p>
</blockquote>
多种引用样式
<blockquote>
    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer posuere erat a ante.</p>
    <footer>Someone famous in <cite title="Source Title">Source Title</cite></footer>
</blockquote>
<hr/>
<blockquote class="blockquote-reverse">
    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer posuere erat a ante.</p>
    <footer>Someone famous in <cite title="Source Title">Source Title</cite></footer>
</blockquote>
<hr/>
列表
无序列表
<ul>
    <li>Consectetur adipiscing elit</li>
    <li>好好学习</li>
    <li>天天向上</li>
</ul>
有序列表
<ol>
    <li>把冰箱门打开</li>
    <li>把水果,饮料,肉拿出来</li>
    <li>把大象塞进去</li>
    <li>把冰箱门带上</li>
</ol>
无样式列表
<ul class="list-unstyled">
    <li>你愁啥</li>
    <li>瞅你咋地</li>
    <li>你再瞅一眼</li>
</ul>
内联列表
<ul class="list-inline">
    <li>啤酒</li>
    <li>饮料</li>
    <li>矿泉水</li>
</ul>
描述, 带有描述的短语列表
<dl>
    <dt>Description lists</dt>
    <dd>A description list is perfect for defining terms.</dd>
    <dt>Euismod</dt>
    <dd>
        <p>Vestibulum id ligula porta felis euismod semper eget lacinia odio sem nec elit.</p>
        <p>Donec id elit non mi porta gravida at eget metus.</p>
    </dd>
</dl>
水平排列的描述
<dl class="dl-horizontal">
    <dt>Description lists</dt>
    <dd>A description list is perfect for defining terms.</dd>
    <dt>Euismod</dt>
    <dd>
        <p>Vestibulum id ligula porta felis euismod semper eget lacinia odio sem nec elit.</p>
        <p>Donec id elit non mi porta gravida at eget metus.</p>
    </dd>
</dl>
<hr/>
内联代码
For example, <code>&lt;section&gt;</code> should be wrapped as inline.
For example, <code>efe</code> should be wrapped as inline.
<hr/>
用户输入, 键入
To switch directories, type <kbd>cd</kbd> followed by the name of the directory.<br>
To edit settings, press <kbd><kbd>ctrl</kbd> + <kbd>,</kbd></kbd>
<hr/>
代码块
<pre>&lt;p&gt;Sample text here...&lt;/p&gt;</pre>
变量<br/>
<var>y</var> = <var>m</var><var>x</var> + <var>b</var><br/>
程序输出
<samp>Hello World!</samp>
<hr/>

</body>
<!-- JavaScript 放置在文档最后面可以使页面加载速度更快 -->
<!-- 可选: 包含 jQuery 库 -->
<script src="../bootstrap3/js/jquery-2.2.3.min.js"></script>
<!-- 可选: 合并了 Bootstrap JavaScript 插件 -->
<script src="../bootstrap3/js/bootstrap.min.js"></script>
</html>
