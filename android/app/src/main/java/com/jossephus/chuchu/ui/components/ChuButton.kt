package com.jossephus.chuchu.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import androidx.compose.ui.unit.dp
import com.jossephus.chuchu.ui.theme.ChuColors
import com.jossephus.chuchu.ui.theme.ChuTypography

enum class ChuButtonVariant {
    Filled,
    Outlined,
    Ghost,
}

@Composable
fun ChuButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    variant: ChuButtonVariant = ChuButtonVariant.Filled,
    bracketed: Boolean = false,
    borderColor: Color? = null,
    backgroundColor: Color? = null,
    contentPadding: PaddingValues = PaddingValues(horizontal = 14.dp, vertical = 10.dp),
    testTag: String? = null,
    contentDescription: String? = null,
    content: @Composable () -> Unit,
) {
    val colors = ChuColors.current
    val typography = ChuTypography.current
    val interactionSource = remember { MutableInteractionSource() }
    val pressed by interactionSource.collectIsPressedAsState()
    val shape = RectangleShape

    val background: Color = when {
        !enabled -> colors.disabledSurface
        variant == ChuButtonVariant.Filled -> colors.accent
        backgroundColor != null -> backgroundColor
        else -> Color.Transparent
    }

    val effectiveBorderColor: Color = borderColor ?: colors.border

    val border: BorderStroke? = when {
        !enabled && variant != ChuButtonVariant.Ghost -> BorderStroke(1.dp, colors.border)
        variant == ChuButtonVariant.Outlined -> BorderStroke(1.dp, effectiveBorderColor)
        else -> null
    }

    val bracketColor: Color = when {
        !enabled -> colors.disabledText
        variant == ChuButtonVariant.Filled -> colors.onAccent
        borderColor != null -> borderColor
        else -> colors.accent
    }

    val semanticsModifier = Modifier.semantics {
        if (testTag != null) {
            this.testTag = testTag
        }
        if (contentDescription != null) {
            this.contentDescription = contentDescription
        }
    }

    Box(
        modifier = modifier
            .then(semanticsModifier)
            .clip(shape)
            .background(background, shape)
            .then(if (border != null) Modifier.border(border, shape) else Modifier)
            .defaultMinSize(minHeight = 36.dp)
            .alpha(if (pressed && enabled) 0.7f else 1f)
            .clickable(
                enabled = enabled,
                interactionSource = interactionSource,
                indication = null,
                onClick = onClick,
            )
            .padding(contentPadding),
        contentAlignment = Alignment.Center,
    ) {
        if (bracketed) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(6.dp),
            ) {
                ChuText("[", style = typography.label, color = bracketColor)
                content()
                ChuText("]", style = typography.label, color = bracketColor)
            }
        } else {
            content()
        }
    }
}
